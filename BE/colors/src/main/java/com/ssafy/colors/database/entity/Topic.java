package com.ssafy.colors.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Topic {

    @Id @GeneratedValue
    private Long id;

    private Long userId;

    private String title;

    @CreationTimestamp
    private LocalDateTime regDate;

    @ColumnDefault("false")
    private boolean isDelete;

    @OneToMany(mappedBy = "memberId")
    private List<Vote> voters;
}
