package com.ssafy.colors.controller;

import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.service.MemberService;
import com.ssafy.colors.util.ValidationChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String DUPLICATED = "duplicated";
    private static final String NONDUPLICATED = "not-duplicated";

    @Autowired
    MemberService memberService;

    @Autowired
    ValidationChecker validationChecker;

    // 입력받은 아이디 중복여부를 체크
    @PostMapping("/chkid")
    public ResponseEntity<Map<String, Object>> checkDuplicatedID(@RequestBody Map<String, Object> reqData) {
        System.out.println("[POST] - /member/chkid");

        String inputId = (String) reqData.get("input-id");
        System.out.println("input-id: " + inputId);

        Map<String, Object> result = new HashMap<>();

        if (memberService.checkID(inputId)) {
            result.put("message", DUPLICATED);
        } else {
            result.put("message", NONDUPLICATED);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 입력받은 닉네임 중복여부를 체크
    @PostMapping("/chknic")
    public ResponseEntity<Map<String, Object>> checkDuplicatedNickname(@RequestBody Map<String, Object> reqData) {
        System.out.println("[POST] - /member/chknic");
        String inputNickname = (String) reqData.get("input-nickname");
        System.out.println("input-nickname: " + inputNickname);

        Map<String, Object> result = new HashMap<>();

        if (memberService.checkNickname(inputNickname)) {
            result.put("message", DUPLICATED);
        } else {
            result.put("message", NONDUPLICATED);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 회원 가입
    @PostMapping()
    public ResponseEntity<Map<String, Object>> registerMember(@RequestBody MemberReq params) {
        System.out.println("[POST] - /member " + params);

        Map<String, Object> result = new HashMap<>();

        String inputId = params.getUserid();
        String inputPwd = params.getPassword();

        if(!(validationChecker.idValidationCheck(inputId)
                && validationChecker.pwdValidationCheck(inputPwd))){
            result.put("message", FAIL);
        } else {
            if (memberService.saveMember(params)) {
                result.put("message", SUCCESS);
            } else {
                result.put("message", FAIL);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 아이디 찾기
    @PostMapping("/findid")
    public ResponseEntity<Map<String, Object>> findID(@RequestBody MemberReq params) {
        System.out.println("[POST] - /member/findid " + params);

        Map<String, Object> result = new HashMap<>();
        String userid = memberService.findID(params);

        if(userid != null) {
            result.put("userid", userid);
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 비밀번호 찾기
    @PostMapping("/findpwd")
    public ResponseEntity<Map<String, Object>> findPassword(@RequestBody MemberReq params) {
        System.out.println("[POST] - /member/findpwd " + params);

        Map<String, Object> result = new HashMap<>();

        if(memberService.findPassword(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/changeinfo")
    public ResponseEntity<Map<String, Object>> updateMemberInfo(@RequestBody MemberReq params) {
        System.out.println("[PUT] - /member/changeinfo");

        Map<String, Object> result = new HashMap<>();

        if(memberService.updateMemberInfo(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/changepwd")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody MemberReq params) {
        System.out.println("[PUT] - /member/changepwd");

        Map<String, Object> result = new HashMap<>();

        String inputPwd = params.getPassword();

        if(!validationChecker.pwdValidationCheck(inputPwd)) {
            result.put("message", "FAIL");
        } else {
            if (memberService.updatePassword(params)) {
                result.put("message", SUCCESS);
            } else {
                result.put("message", FAIL);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable String userid) {
        System.out.println("[DELETE] - /member/{user_id}");

        Map<String, Object> result = new HashMap<>();

        if (memberService.deleteMember(userid)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
