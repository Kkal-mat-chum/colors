package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.request.Mail;
import com.ssafy.colors.request.MemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("memberService")
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailService mailService;

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public boolean checkId(String inputId) {
        List<Member> byId = memberRepository.findById(inputId);
        if (byId.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkNickname(String inputnickname) {
        List<Member> byId = memberRepository.findByNickname(inputnickname);
        if (byId.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String findId(String name, String email) {
        List<Member> byId = memberRepository.findByEmail(email);
        System.out.println("email = " + email);
        System.out.println("byId.get(0) = " + byId.get(0));

        if (byId.isEmpty()) {
            return "fail";
        }
        if (!byId.get(0).getName().equals(name)|| byId.get(0).isDeleted()) {
            return "fail";
        }
        return byId.get(0).getUserId();

    }

    @Override
    public boolean findPW(String id, String email) {
        List<Member> findById = memberRepository.findById(id);
        if(findById.isEmpty()){
            return false;
        }
        if (findById.get(0).getEmail().equals(email)) {
            Mail mail = new Mail();
            mail.setAddress(email);
            mail.setMessage("임시비밀번호는 1234 입니다.");
            mail.setTitle("임시비밀번호");

            mailService.mailSend(mail);
            findById.get(0).setPassword("1234");
            return true;
        }
        return false;
    }

    @Override
    public Member getMember(String memberid) {
        return memberRepository.findById(memberid).get(0);
    }

    @Override
    public void modifyMember(String userid, String nickname, String name) {
        List<Member> byId = memberRepository.findById(userid);
        byId.get(0).setNickname(nickname);
        byId.get(0).setName(name);
    }

    @Override
    public void deleteMember(String memberid) {
        List<Member> byId = memberRepository.findById(memberid);
        byId.get(0).setDeleted(true);
    }
}
