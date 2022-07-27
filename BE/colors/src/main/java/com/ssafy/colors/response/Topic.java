package com.ssafy.colors.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Topic {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String title;

    private LocalDate regDate;

    private Long weekNum;

    private boolean isDeleted;


}
