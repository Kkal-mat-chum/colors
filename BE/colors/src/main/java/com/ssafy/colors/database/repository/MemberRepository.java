package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public List<Member> findById(String memberId){
        return em.createQuery("select m from Member m where m.userId = :userId", Member.class).
                setParameter("userId", memberId).getResultList();
    }

    public List<Member> findByNickname(String nickName){
        return em.createQuery("select m from Member m where m.nickname = :nickname", Member.class).
                setParameter("nickname", nickName).getResultList();
    }

    public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class).
                setParameter("email", email).getResultList();
    }

}
