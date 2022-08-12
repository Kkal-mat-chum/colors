package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findFirstByUserId(String inputId);

    public Member findFirstByNickname(String inputNickname);

    public Member findByNameAndEmail(String name, String email);

    public Member findByUserIdAndPassword(String userId, String password);

    @Modifying
    @Transactional
    @Query("UPDATE Member as m " +
            "SET m.password = :randomPwd " +
            "WHERE m.userId = :userId and m.email = :email")
    public int updatePassword(@Param("randomPwd") String randomPwd,
                              @Param("userId") String userId,
                              @Param("email") String email);

    @Modifying
    @Transactional
    @Query("UPDATE Member as m " +
            "SET m.nickname = :nickname, m.name = :name " +
            "WHERE m.userId = :userId")
    public int updateMemberInfo(@Param("nickname") String inputNickname,
                                @Param("name") String inputName,
                                @Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE Member as m " +
            "SET m.profileUrl = :url " +
            "WHERE m.userId = :userId")
    public int updateProfileImage(@Param("userId") String userId,
                                  @Param("url") String url);

    @Modifying
    @Transactional
    @Query("UPDATE Member as m " +
            "SET m.password = :password " +
            "WHERE m.userId = :userId")
    public int changePassword(@Param("password") String inputPwd,
                              @Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE Member as m " +
            "SET m.isDeleted = true " +
            "WHERE m.userId = :userId")
    public int updateIsDeleted(@Param("userId") String userId);

    public Member findByPasswordLike(String password);
}
