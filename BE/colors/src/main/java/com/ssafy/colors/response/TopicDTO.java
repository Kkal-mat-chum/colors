package com.ssafy.colors.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicDTO {
    private Long id;
    private String title;
    private boolean isRecommend;
    private long cnt;



}
