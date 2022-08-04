package com.ssafy.colors.controller;

import com.ssafy.colors.request.LoginReq;
import com.ssafy.colors.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginReq user){
        String result = "fail";
        if(authService.login(user)){
            result = "success";
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 로그인 성공시 토큰 생성


}
