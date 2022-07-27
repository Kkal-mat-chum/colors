package com.ssafy.colors.api.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class MeetingResult {

    @Id @GeneratedValue
    private Long id;

    private Long roomId;

    private Long userId;

    private String imageURL;

    private String colorCode;

    // true : 최다 투표, false : 이외
    private boolean top1 ;

}
