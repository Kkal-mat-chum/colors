package com.ssafy.colors.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {


    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        System.out.println("\"hello\" = " + "hello");
        return new ResponseEntity<String> ("Hello" , HttpStatus.OK);
    }

    // Login
    // 로그인 성공시 토큰 생성


}
