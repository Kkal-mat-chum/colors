package com.ssafy.colors.database.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "member")
@Entity
@Getter
@Setter
@ToString(exclude = {"rooms", "results", "meetingVoters"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member extends BaseEntity {
    @Column(name = "user_id", length = 15, nullable = false)
    String userId;

    @Column(name = "password", length = 100, nullable = false)
    String password;

    @Column(name = "profile_url", length = 100)
    String profileUrl;

    @Column(name = "name", length = 30, nullable = false)
    String name;

    @Column(name = "nickname", length = 30, nullable = false)
    String nickname;

    @Column(name = "email", length = 100, nullable = false)
    String email;

    @Column(name = "point")
    @ColumnDefault("0")
    int point;

    @Column(name = "auth_grade")
    @ColumnDefault("false")
    boolean authGrade;

    @Column(name = "reg_date", nullable = true)
    LocalDateTime regDate;

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    boolean isDeleted;

    @OneToMany(mappedBy = "host")
    List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    List<MeetingResult> results = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    List<MeetingVote> meetingVoters = new ArrayList<>();
}
