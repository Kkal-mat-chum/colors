package com.ssafy.colors.database.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "meeting_vote")
@Entity
@Getter
@Setter
@ToString(exclude = "")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingVote extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "res_id")
    private MeetingResult meetingResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_long_id")
    private Member member;
}
