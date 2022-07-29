package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.request.MemberReq;
import org.springframework.stereotype.Service;

public interface MemberService {
    public void saveMember(Member member);

    boolean checkId(String inputId);

    boolean checkNickname(String inputnickname);

    String findId(String name, String email);

    boolean findPW(String id, String email);

    Member getMember(String memberid);

    void modifyMember(String userid,String nickname, String name);

    void deleteMember(String memberid);
}
