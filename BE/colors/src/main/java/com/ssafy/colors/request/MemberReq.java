package com.ssafy.colors.request;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberReq {
    private String userid;
    private String password;
    private String name;
    private String nickname;
    private String email;
}
