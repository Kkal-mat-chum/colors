package com.ssafy.colors.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicRes {

    private String title;

    private boolean recommend;

    private Long cnt;
}
