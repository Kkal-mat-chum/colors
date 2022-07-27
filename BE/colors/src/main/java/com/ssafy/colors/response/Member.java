package com.ssafy.colors.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String password;

    private String nickName;

    private String email;

    private int point;

    private boolean authGrade;

    private LocalDateTime regDate;

    // false : 가입 , True : 탈퇴
    private boolean isDeleted;
}
