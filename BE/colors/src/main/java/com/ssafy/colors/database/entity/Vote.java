package com.ssafy.colors.database.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Table(name = "vote")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Vote extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private Long memberId;

    private boolean isDelete;

    public Vote(Long memberId, Topic topic, boolean isDelete) {
        this.memberId = memberId;
        this.addVote(topic);
        this.isDelete = isDelete;
    }

    public void addVote(Topic topic) {
        this.topic = topic;
        topic.getVoters().add(this);
    }

//    @Override
//    public boolean equals(Object obj) {
//        System.out.println(((VoteDTO) obj).getUserId() + " " + ((VoteDTO) obj).getTopicId());
//        return (((VoteDTO) obj).getUserId().equals(this.memberId) && ((VoteDTO) obj).getTopicId().equals(this.topic.getId()));
//
//    }
}
