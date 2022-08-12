package com.ssafy.colors.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRes {
    private Long id;
    private String userId;
    private String profileUrl;
    private String name;
    private String nickname;
    private String email;
    private int point;
    private boolean authGrade;
}
