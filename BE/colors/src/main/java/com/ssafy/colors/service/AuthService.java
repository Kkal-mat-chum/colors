package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.LoginReq;
import com.ssafy.colors.request.Mail;
import com.ssafy.colors.response.MemberRes;
import com.ssafy.colors.util.RandomStringGenerator;
import com.ssafy.colors.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RandomStringGenerator randomStringGenerator;

    @Autowired
    MailService mailService;

    @Autowired
    SHA256 sha256;

    public Map<String, Object> login(LoginReq user) throws NoSuchAlgorithmException {
        Member findByuserId = memberRepository.findFirstByUserId(user.getUserId());
        HashMap<String, Object> result = new HashMap<>();

        if (findByuserId != null && !findByuserId.isDeleted() && findByuserId.getPassword().equals(sha256.encrypt(user.getPassword()))) {
            MemberRes member = MemberRes.builder()
                    .id(findByuserId.getId())
                    .userId(findByuserId.getUserId())
                    .profileUrl(findByuserId.getProfileUrl())
                    .name(findByuserId.getName())
                    .nickname(findByuserId.getNickname())
                    .email(findByuserId.getEmail())
                    .point(findByuserId.getPoint())
                    .authGrade(findByuserId.isAuthGrade())
                    .build();
            result.put("member", member);
            result.put("result", true);

            return result;
        }
        result.put("result", false);
        return result;
    }


    public String generateAndSendAuthCode(String email) {
        String authCode = randomStringGenerator.generateRandomPassword(8);
        Mail mail = Mail.builder()
                .address(email)
                .title("[깔맞춤] 회원가입 인증 코드 발송")
                .message("인증 코드 : " + authCode)
                .build();
        mailService.mailSend(mail);

        return authCode;
    }
}
