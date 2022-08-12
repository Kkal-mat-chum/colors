package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.LoginReq;
import com.ssafy.colors.request.Mail;
import com.ssafy.colors.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String, Object> login(LoginReq user) {
        Member findByuserId = memberRepository.findFirstByUserId(user.getUserId());
        HashMap<String, Object> result = new HashMap<>();
        if (findByuserId != null && findByuserId.getPassword().equals(user.getPassword())) {
            result.put("member", findByuserId);
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
