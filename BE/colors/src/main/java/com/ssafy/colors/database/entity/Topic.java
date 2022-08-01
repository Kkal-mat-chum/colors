package com.ssafy.colors.database.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "topic")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic extends BaseEntity {
    @Column(name = "user_int_id", nullable = false)
    Long userIntId;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "reg_date", nullable = false)
    LocalDateTime regDate;

    @Column(name = "is_deleted", nullable = false)
    Boolean isDeleted;
}
