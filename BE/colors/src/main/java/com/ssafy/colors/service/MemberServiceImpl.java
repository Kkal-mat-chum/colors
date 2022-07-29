package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.MemberReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public boolean saveMember(MemberReq memberReq) {
        Member member = new Member();
        member.setUserId(memberReq.getUserid());
        member.setPassword(memberReq.getPassword());
        member.setName(memberReq.getName());
        member.setNickname(memberReq.getNickname());
        member.setEmail(memberReq.getEmail());
        member.setPoint(0);
        member.setAuthGrade(false);
        member.setDeleted(false);

        try {
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
