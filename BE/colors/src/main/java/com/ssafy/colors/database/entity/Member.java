package com.ssafy.colors.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Table(name = "member")
@Entity
@Getter
@Setter
public class Member extends BaseEntity {
    @Column(name = "user_id", length = 15, nullable = false)
    String userId;

    @Column(name = "profile_url", length = 100, nullable = true)
    String profileUrl;

    @Column(name = "name", length = 30, nullable = false)
    String name;

    @Column(name = "nickname", length = 30, nullable = false)
    String nickname;

    @Column(name = "email", length = 100, nullable = false)
    String email;

    @Column(name = "point", nullable = false)
    int point;

    @Column(name = "auth_grade", nullable = false)
    boolean authGrade;

    @Column(name = "reg_date", nullable = true)
    String regDate;

    @Column(name = "is_deleted", nullable = false)
    boolean isDeleted;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 30, nullable = false)
    String password;
}
