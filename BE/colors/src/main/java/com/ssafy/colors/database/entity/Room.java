package com.ssafy.colors.database.entity;

import com.ssafy.colors.enumdata.RoomStatus;
import com.ssafy.colors.enumdata.RoomType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller 작성을 위해 임시로 만든 테이블입니다.
 * 추후 테이블 간에 관계 설정이 필요합니다.
 */

@Table(name = "room")
@Entity
@Getter
@Setter
@ToString(exclude = {"host", "topic", "results"})
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Room extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private Member host;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "topic_id", nullable = true)
//    private Topic topic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = true)
    private Topic topic;

//    @Column(name = "topic_id", nullable = true)
//    Long topicId;

    @Column(name = "room_code", length = 15, nullable = false)
    String roomCode;

    @Column(name = "room_type", nullable = false)
    @Enumerated(EnumType.STRING)
    RoomType roomType;

    @Column(name = "cdate", nullable = false)
    LocalDateTime cDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    RoomStatus status;

    @OneToMany(mappedBy = "room")
    List<MeetingResult> results = new ArrayList<>();
}
