package com.ssafy.colors.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomRes {
    Long roomid;
    Long hostid;
    String roomcode;
    String title;
    String roomtype;
    String status;
}
