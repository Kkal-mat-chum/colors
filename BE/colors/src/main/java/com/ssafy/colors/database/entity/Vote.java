package com.ssafy.colors.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Vote {
    @Id @GeneratedValue
    private Long id;

    private Long topicId;

    private Long memberId;

}
