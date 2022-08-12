package com.ssafy.colors.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomReq {
    Long hostid;
    Long topicid;
    String roomtype;
}
