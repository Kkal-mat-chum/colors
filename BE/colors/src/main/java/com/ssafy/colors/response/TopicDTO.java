package com.ssafy.colors.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicDTO {
    private String title;
    private boolean recommend;
    private int cnt;
}
