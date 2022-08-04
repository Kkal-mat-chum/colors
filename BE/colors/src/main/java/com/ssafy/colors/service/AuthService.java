package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    MemberRepository memberRepository;

    public boolean login(LoginReq user) {
        Member findByuserId = memberRepository.findFirstByUserId(user.getUserId());
        if (findByuserId.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
