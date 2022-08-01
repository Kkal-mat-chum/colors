package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.MemberReq;
import com.ssafy.colors.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RandomStringGenerator randomStringGenerator;

    @Override
    public boolean checkID(String inputId) {
        return memberRepository.findFirstByUserId(inputId) != null ? true : false;
    }

    @Override
    public boolean checkNickname(String inputNickname) {
        return memberRepository.findFirstByNickname(inputNickname) != null ? true : false;
    }

    @Override
    public boolean saveMember(MemberReq memberReq) {
        System.out.println(LocalDateTime.now());
        Member member = Member.builder()
                .userId(memberReq.getUserid())
                .password(memberReq.getPassword())
                .name(memberReq.getName())
                .nickname(memberReq.getNickname())
                .email(memberReq.getEmail())
                .point(0)
                .authGrade(false)
                .regDate(LocalDateTime.now())
                .isDeleted(false)
                .build();

        try {
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String findID(MemberReq memberReq) {
        String name = memberReq.getName();
        String email = memberReq.getEmail();
        Member member = memberRepository.findByNameAndEmail(name, email);

        if (member != null) return member.getUserId();
        else return null;
    }

    @Override
    public boolean findPassword(MemberReq memberReq) {
        String userId = memberReq.getUserid();
        String email = memberReq.getEmail();

        String randomPwd = randomStringGenerator.generateRandomPassword(10);

        System.out.println("RAND PWD " + randomPwd);

        String lower = randomPwd.toLowerCase(Locale.ROOT);
        System.out.println("LOWER PWD " + lower);

        int result = memberRepository.updatePassword(randomPwd, userId, email);

        Member member = memberRepository.findByPasswordLike(lower);
        System.out.println(member);

        // if result > 0 (성공) 이메일 전송
        // else false return

        return result > 0 ? true : false;
    }

    @Override
    public boolean updateMemberInfo(MemberReq memberReq) {
        String inputNickname = memberReq.getNickname();
        String inputName = memberReq.getName();
        String inputId = memberReq.getUserid();

        int result = memberRepository.updateMemberInfo(inputNickname, inputName, inputId);

        return result > 0 ? true : false;
    }

    @Override
    public boolean updatePassword(MemberReq memberReq) {
        String inputPwd = memberReq.getPassword();
        String inputId = memberReq.getUserid();

        int result = memberRepository.updatePassword(inputPwd, inputId);

        return result > 0 ? true : false;
    }

    @Override
    public boolean deleteMember(String userId) {
        int result = memberRepository.updateIsDeleted(userId);
        return result > 0 ? true : false;
    }

//    @Override
//    public boolean checkID(String inputId) {
//        return memberRepository.checkDuplicatedID(inputId);
//    }
//
//    @Override
//    public boolean checkNickname(String inputNickname) {
//        return memberRepository.checkDuplicatedNickname(inputNickname);
//    }
//
//    @Override
//    public boolean saveMember(MemberReq memberReq) {
//        Member member = Member.builder()
//                .userId(memberReq.getUserid())
//                .password(memberReq.getPassword())
//                .name(memberReq.getName())
//                .nickname(memberReq.getNickname())
//                .email(memberReq.getEmail())
//                .point(0)
//                .authGrade(false)
//                .isDeleted(false)
//                .build();
//
//        System.out.println(member);
//
////        member.setUserId(memberReq.getUserid());
////        member.setPassword(memberReq.getPassword());
////        member.setName(memberReq.getName());
////        member.setNickname(memberReq.getNickname());
////        member.setEmail(memberReq.getEmail());
////        member.setPoint(0);
////        member.setAuthGrade(false);
////        member.setDeleted(false);
//
//        try {
//            return memberRepository.save(member);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public String findID(MemberReq memberReq) {
//        return memberRepository.findID(memberReq);
//    }
//
//    @Override
//    public boolean findPassword(MemberReq memberReq) {
//        // email로 비밀번호 보내는 로직 추가
//        System.out.println("findPassword");
//        System.out.println(memberRepository.findPassword(memberReq));
//        return true;
//    }
}
