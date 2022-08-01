//package com.ssafy.colors.util;
//
//import io.jsonwebtoken.Header;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.util.Base64;
//import java.util.Date;
//
//@Component
//public class JWTUtil {
//
//    private String secretKey = "AFNF23AHAH8AJN8AHAS";
//    // jwt 토큰 생성
//    public String createAccessToken(String userId){
//        Date now = new Date();
//        Date expiration = new Date(now.getTime() + Duration.ofDays(1).toMillis());  // 만료기간
//
//
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//                .setIssuer(userId)
//                .setIssuedAt(now)
//                .setExpiration(expiration)
//                .setSubject("login")
//                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
//                .compact();
//    }
//
//    public String createRefreshToken(String userId){
//
//        String token = "";
//
//        return token;
//    }
//    // jwt 토큰 유효성 검사
//
//}
