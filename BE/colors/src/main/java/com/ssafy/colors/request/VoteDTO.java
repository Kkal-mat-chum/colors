package com.ssafy.colors.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteDTO {
    Long userId;
    Long topicId;
}
