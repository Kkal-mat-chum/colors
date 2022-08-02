package com.ssafy.colors.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class MemberRes {
    private String userId;
    private String nickName;
    private String email;
    private String profileUrl;
    private String name;
    private String nickname;
    private int point;
    private boolean authGrade;
    private String regDate;
    private boolean isDeleted;
}
