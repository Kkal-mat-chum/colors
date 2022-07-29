package com.ssafy.colors.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberReq {
    private String userid;
    private String password;
    private String name;
    private String nickname;
    private String email;
}
