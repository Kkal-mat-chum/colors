package com.ssafy.colors.controller;

import com.ssafy.colors.request.LoginReq;
import com.ssafy.colors.service.AuthService;
import com.ssafy.colors.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    AuthService authService;

    @Autowired
    JWTUtil jwtUtil;
    // Login
    @PostMapping("/login")
    public ResponseEntity<HashMap> login(@RequestBody LoginReq user){
        System.out.println("[POST] - auth/login");
        System.out.println(user.getUserId());
        System.out.println(user.getPassword());

        String result = "fail";
        HashMap<String, Object> resultmap = new HashMap<>();
        if(authService.login(user)){
            result = "success";
            resultmap.put("auth_token", jwtUtil.createAccessToken(user.getUserId()));
        }

        return new ResponseEntity<>(resultmap, HttpStatus.OK);
    }

    // 회원가입 시 이메일 인증코드 발송
    @PostMapping("/email")
    public ResponseEntity<Map<String, Object>> checkEmail(@RequestBody Map<String, Object> params) {
        System.out.println("[POST] - /member/email");

        Map<String, Object> result = new HashMap<>();
        String email = (String) params.get("email");
        String code = authService.generateAndSendAuthCode(email);

        if(code != null) {
            result.put("message", SUCCESS);
            result.put("authcode", code);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
