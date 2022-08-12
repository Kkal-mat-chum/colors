package com.ssafy.colors.controller;


import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.response.MemberRes;
import com.ssafy.colors.service.MemberService;
import com.ssafy.colors.service.S3Service;
import com.ssafy.colors.util.ValidationChecker;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Member API", tags = {"Member"})
@CrossOrigin(origins = "*")
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
    @ApiOperation(value = "아이디 중복여부 확인", notes = "입력받은 아이디의 중복 여부를 확인한다.")
    @ApiImplicitParam(
            name = "입력 아이디",
            value = "input-id",
            required = true,
            dataType = "string")
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
    @ApiOperation(value = "닉네임 중복여부 확인", notes = "입력 받은 닉네임의 중복 여부를 확인한다.")
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
    @ApiOperation(value = "회원 정보 등록", notes = "입력 받은 회원의 정보를 데이터베이스에 저장한다.")
    public ResponseEntity<Map<String, Object>> registerMember(@RequestBody @ApiParam(value = "회원가입 정보", required = true) MemberReq params) {
        System.out.println("[POST] - /member " + params);

        Map<String, Object> result = new HashMap<>();

        String inputId = params.getUserid();
        String inputPwd = params.getPassword();

        if (!(validationChecker.idValidationCheck(inputId)
                && validationChecker.pwdValidationCheck(inputPwd))) {
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

    @GetMapping("{userid}")
    @ApiOperation(value = "회원 정보 받기", notes = "아이디와 일치하는 회원의 정보를 반환한다.")
    public ResponseEntity<Map<String, Object>> getMemberInfo(@PathVariable String userid) {
        System.out.println("[GET] - /member/{user_id}");

        Map<String, Object> result = new HashMap<>();
        MemberRes member = memberService.getMemberInfo(userid);

        if (member != null) {
            result.put("message", SUCCESS);
            result.put("data", member);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 아이디 찾기
    @PostMapping("/findid")
    @ApiOperation(value = "회원 아이디 찾기", notes = "회원의 이름과 이메일로 아이디를 찾는다.")
    public ResponseEntity<Map<String, Object>> findID(@RequestBody MemberReq params) {
        System.out.println("[POST] - /member/findid " + params);

        Map<String, Object> result = new HashMap<>();
        String userid = memberService.findID(params);

        if (userid != null) {
            result.put("userid", userid);
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 비밀번호 찾기
    @PostMapping("/findpwd")
    @ApiOperation(value = "임시 비밀번호 발급", notes = "회원의 아이디와 이메일을 입력받아 임시 비밀번호를 발급한다.")
    public ResponseEntity<Map<String, Object>> findPassword(@RequestBody MemberReq params) {
        System.out.println("[POST] - /member/findpwd " + params);

        Map<String, Object> result = new HashMap<>();

        if (memberService.findPassword(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 회원정보(이름, 닉네임) 변경
    @PutMapping("/changeinfo")
    @ApiOperation(value = "회원 정보 변경", notes = "입력받은 회원의 이름과 닉네임 정보를 변경한다.")
    public ResponseEntity<Map<String, Object>> updateMemberInfo(@RequestBody MemberReq params) {
        System.out.println("[PUT] - /member/changeinfo");

        Map<String, Object> result = new HashMap<>();

        if(memberService.checkPassword(params.getUserid(), params.getPassword())) {
            if (memberService.updateMemberInfo(params)) {
                result.put("message", SUCCESS);
            } else {
                result.put("message", FAIL);
            }
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/changeimg")
    public ResponseEntity<Map<String, Object>> updateMemberProfileImage(@RequestBody Map<String, Object> params) {
        System.out.println("[POST] - /member/changeimg");

        Map<String, Object> result = new HashMap<>();
        String userId = (String) params.get("userid");
        String imgUrl = (String) params.get("image-url");

        if(memberService.updateMemberImage(userId, imgUrl)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 비밀번호 변경
    @PutMapping("/changepwd")
    @ApiOperation(value = "비밀번호 변경", notes = "입력받은 회원의 비밀번호를 변경한다.")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody MemberReq params) {
        System.out.println("[PUT] - /member/changepwd");

        Map<String, Object> result = new HashMap<>();

        String inputPwd = params.getPassword();

        if (!validationChecker.pwdValidationCheck(inputPwd)) {
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

    // 회원 탈퇴
    @DeleteMapping("/{userid}")
    @ApiOperation(value = "회원 탈퇴", notes = "회원의 탈퇴 정보를 등록한다.")
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

    // S3 테스트
    @Autowired
    S3Service s3Service;

    // 단일 파일 업로드
    @PostMapping("upload")
    public ResponseEntity<Map<String, Object>> uploadImage(MultipartFile file) throws IOException {
        System.out.println("[POST] - /member/upload");
        String imgPath = s3Service.uploadImage(file);
        System.out.println(imgPath);

        return null;
    }


    // 여러 개 업로드
    @PostMapping("uploads")
    public ResponseEntity<Map<String, Object>> uploadImages(List<MultipartFile> files) throws IOException {
        System.out.println("[POST] - /member/uploads");

        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }

        return null;
    }
}
