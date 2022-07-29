package com.ssafy.colors.controller;


import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    // 아이디 중복 검사
    @GetMapping("/chkid/{inputId}")
    public ResponseEntity<String> checkDuplicateId(@PathVariable String inputId) {
        String result = "duplicated";
        if (memberService.checkId(inputId)) {
            result = "non-duplicated";
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 닉네임 중복 검사
    @GetMapping("/chknickname/{inputnickname}")
    public ResponseEntity<String> checkDuplicateNickname(@PathVariable String inputnickname) {
        String result = "duplicated";
        if (memberService.checkNickname(inputnickname)) {
            result = "non-duplicated";
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 아이디 찾기
    @PostMapping("/findid")
    public ResponseEntity<String> findId(@RequestBody HashMap<String, String> params) {
        String result = "해당 아이디가 존재하지 않습니다.";
        String name = params.get("name");
        String email = params.get("email");
        String findId = memberService.findId(name, email);

        if (!findId.equals("fail")) {
            result = findId;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 비밀번호 찾기
    @PostMapping("/findpwd")
    public ResponseEntity<String> findPW(@RequestBody HashMap<String, String> params) {
        String id = params.get("id");
        String email = params.get("email");
        String result = "정보가 올바르지 않습니다.";
        boolean success = memberService.findPW(id, email);
        if (success) {
            result = "임시 비밀번호를 이메일로 전송했습니다.";
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    // 회원정보 가져오기
    @GetMapping("/{memberid}")
    public ResponseEntity<Member> getMemberInfo(@PathVariable String memberid) {
        Member member = memberService.getMember(memberid);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }


    // 회원가입
    @PostMapping("/")
    public ResponseEntity<String> registMember(@RequestBody Member member) {
        System.out.println("member = " + member);
        memberService.saveMember(member);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    // 회원정보 수정

    @PutMapping("/info/{userId}")
    public ResponseEntity<String> updatememberInfo(@PathVariable String userId, @RequestBody HashMap<String, String> params) {
        String nickname = params.get("nickname");
        String name = params.get("name");
        memberService.modifyMember(userId, nickname, name);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    // 회원정보 삭제
    @DeleteMapping("/{memberid}")
    public ResponseEntity<String> deleteMember(@PathVariable String memberid) {
        memberService.deleteMember(memberid);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
