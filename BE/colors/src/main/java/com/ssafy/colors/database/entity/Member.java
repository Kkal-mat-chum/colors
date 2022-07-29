package com.ssafy.colors.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "member")
@Entity
@Getter
@Setter @ToString
public class Member extends BaseEntity {
    @Column(name = "user_id", length = 15, nullable = false)
    String userId;

    @Column(name = "password" ,length = 30, nullable = false)
    String password;

    @Column(name = "profile_url", length = 100)
    String profileUrl;

    @Column(name = "name", length = 30, nullable = false)
    String name;

    @Column(name = "nickname", length = 30, nullable = false)
    String nickname;

    @Column(name = "email", length = 100 , nullable = false)
    String email;

    @Column(name = "point")
    @ColumnDefault("0")
    int point;

    @Column(name = "auth_grade")
    @ColumnDefault("false")
    boolean authGrade;

    @Column(name = "reg_date")
    @CreationTimestamp
    LocalDateTime regDate;

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    boolean isDeleted;

}
