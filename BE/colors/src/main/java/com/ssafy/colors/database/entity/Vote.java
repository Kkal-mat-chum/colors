package com.ssafy.colors.database.entity;

import com.ssafy.colors.request.VoteDTO;
import com.sun.xml.bind.WhiteSpaceProcessor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue
    private Long id;
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
