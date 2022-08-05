package com.ssafy.colors.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper
        ;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

    private String secretKey = "xhzmsdmf-anjfhgkaus-whgdmfRk-rkskekfkakqktk";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    private long accessTokenExp = 3 * 60 * 60 * 1000;

    private long refreshTokenExp = 14 * 24 * 60 * 60 * 1000;

    // access 토큰 생성
    public String createAccessToken(String userId) {
        return Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .claim("userId", userId).setExpiration(new Date(System.currentTimeMillis() + accessTokenExp))
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }

    // refresh 토큰 생성
    public String createRefreshToken() {
        return Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExp))
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }

    // jwt 토큰 유효성 검사
    public String validToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        System.out.println("claimsJws = " + claimsJws);
        return claimsJws.getBody().get("userId").toString();
    }

//     토큰 값 꺼내기
    public Map<String,Object> getInfo(String token) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = new String(Base64.getDecoder().decode(
                token.split("\\.")[1]
        ));
        HashMap<String, Object> map = objectMapper.readValue(s,HashMap.class);
        return map;
    }

}
