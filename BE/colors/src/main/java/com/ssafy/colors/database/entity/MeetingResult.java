package com.ssafy.colors.database.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Controller 작성을 위해 임시로 만든 테이블입니다.
 * 추후 테이블 간에 관계 설정이 필요합니다.
 */

@Table(name = "meeting_result")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingResult extends BaseEntity {
    @Column(name = "room_id", nullable = false)
    Long roomId;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "image_url", length = 200, nullable = true)
    String imageUrl;

    @Column(name = "color_code", length = 10, nullable = true)
    String colorCode;

    @Column(name = "top1", nullable = false)
    boolean top1;
}
