package com.ssafy.colors.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "meeting_result")
@Entity
@Getter
@Setter
@ToString(exclude = {"room", "member", "votes"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingResult extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @Column(name = "image_url", length = 200, nullable = true)
    String imageUrl;

    @Column(name = "color_code", length = 10, nullable = true)
    String colorCode;

    @Column(name = "top1", nullable = false)
    boolean top1;

    @OneToMany(mappedBy = "meetingResult")
    List<MeetingVote> votes = new ArrayList<>();
}
