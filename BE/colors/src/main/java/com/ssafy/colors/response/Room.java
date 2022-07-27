package com.ssafy.colors.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Room {
    @Id @GeneratedValue
    private Long id;

    private String roomCode;

    // SINGLE , GROUP, RANDOM
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private LocalDateTime createdDate;

    // WAIT, STARTED, CLOSED
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
}
