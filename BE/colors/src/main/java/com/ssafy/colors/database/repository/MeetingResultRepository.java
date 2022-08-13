package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.MeetingResult;
import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MeetingResultRepository extends JpaRepository<MeetingResult, Long> {
    public List<MeetingResult> findByRoomOrderByMember(Room room);

    public MeetingResult findByRoomAndMemberAndTop1(Room room, Member member, boolean b);

    public List<MeetingResult> findByRoomAndMember(Room room, Member member);

    public MeetingResult findByRoomAndMemberAndColorCode(Room room, Member member, String colorCode);

    @Query("SELECT DISTINCT r.member " +
            "FROM MeetingResult as r " +
            "WHERE r.room = :room")
    public List<Member> findDistinctMember(@Param("room") Room room);

    @Modifying
    @Transactional
    @Query("UPDATE MeetingResult mr " +
            "SET mr.top1 = true " +
            "WHERE mr.room = :room AND mr.member = :member AND mr.colorCode = :code")
    public int updateTop1(@Param("room") Room room,
                          @Param("member") Member member,
                          @Param("code") String code);

    @Modifying
    @Transactional
    @Query("UPDATE MeetingResult mr " +
            "SET mr.top1 = true " +
            "WHERE mr.id = :id")
    public void updateTop1ById(@Param("id") long id);
}
