package com.ssafy.colors.controller;


import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping()
    public ResponseEntity<String> registerMember(@RequestBody MemberReq registerInfo) {
        if(memberService.saveMember(registerInfo)) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }

        return new ResponseEntity<>("fail", HttpStatus.OK);
    }
}
