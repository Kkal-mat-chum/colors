package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.response.MemberRes;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

public interface MemberService {
    public boolean checkID(String inputId);
    public boolean checkNickname(String inputNickname);
    public boolean saveMember(MemberReq memberReq) throws NoSuchAlgorithmException;
    public MemberRes getMemberInfo(String userId);
    public String findID(MemberReq memberReq);
    public boolean findPassword(MemberReq memberReq) throws NoSuchAlgorithmException;
    public boolean checkPassword(String userId, String password) throws NoSuchAlgorithmException;
    public boolean updateMemberInfo(MemberReq memberReq);
    public boolean updateMemberImage(String userId, String url);
    public boolean updatePassword(MemberReq memberReq) throws NoSuchAlgorithmException;
    public boolean deleteMember(String userId);
}
