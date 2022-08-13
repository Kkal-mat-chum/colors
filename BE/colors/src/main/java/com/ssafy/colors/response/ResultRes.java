package com.ssafy.colors.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultRes {
    private String userid;
    private String name;
    private String nickname;
    private List<String> urls;
    private List<String> colors;
}
