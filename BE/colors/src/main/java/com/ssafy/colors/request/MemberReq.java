package com.ssafy.colors.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberReq {
    @ApiModelProperty(example = "회원 아이디")
    private String userid;
    @ApiModelProperty(example = "회원 비밀번호")
    private String password;
    @ApiModelProperty(example = "회원 이름")
    private String name;
    @ApiModelProperty(example = "회원 닉네임")
    private String nickname;
    @ApiModelProperty(example = "회원 이메일")
    private String email;
}
