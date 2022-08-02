package com.ssafy.colors.database.entity;

import com.ssafy.colors.request.VoteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Vote {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id")
    private Topic topic;

    private Long memberId;

    private boolean isDelete;

    public void addVote(Topic topic) {
        this.topic = topic;
        topic.getVoters().add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VoteDTO) {
            return (((VoteDTO) obj).getTopicId() == this.memberId && ((VoteDTO) obj).getTopicId() == this.topic.getId());

        }
        return super.equals(obj);
    }


}
