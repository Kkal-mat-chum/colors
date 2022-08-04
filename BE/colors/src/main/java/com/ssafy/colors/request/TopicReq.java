package com.ssafy.colors.request;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

@Data
public class TopicReq {
    PageRequest pageRequest;
    String keyword;
    Long userId;
}
