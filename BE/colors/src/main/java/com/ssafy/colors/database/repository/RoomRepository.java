package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.enumdata.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findFirstByRoomCodeAndStatus(String code, RoomStatus status);
    @Query("SELECT r FROM Room as r " +
            "WHERE r.topic = :topic AND r.status = :status AND r.isFull = :full")
    public List<Room> findAccessibleRoom(@Param("topic") Topic topic,
                                         @Param("status") RoomStatus status,
                                         @Param("full") boolean full);

    public Room findByIdAndHost(Long id, Member host);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update room set is_full = not(is_full) where id = :roomId ")
    public int reverseCapacity(@Param("roomId") Long roomId);

    @Modifying
    @Transactional
    @Query("UPDATE Room as r " +
            "SET r.status = :status " +
            "Where r.host = :host And r.id = :roomId")
    public int updateRoomStatus(@Param("roomId") Long roomId,
                                @Param("host") Member host,
                                @Param("status") RoomStatus status);

    @Query(nativeQuery = true,
            value = "select r1.*\n" +
                    "from room as r1, ( select max(cdate) as maxdate, room_type\n" +
                    "                   from room\n" +
                    "                   where id in (select distinct `room_id` from `meeting_result` where `user_id` = :userId)\n" +
                    "                   group by room_type) as r2\n" +
                    "where r1.id in (   select distinct `room_id` " +
                    "                   from `meeting_result` " +
                    "                   where `user_id` = :userId)\n" +
                    "and r1.cdate = r2.maxdate and r1.room_type = r2.room_type;")
    public List<Room> getRecentMeetingInfo(@Param("userId") long userId);

    @Query(nativeQuery = true,
            value = "select r.* \n" +
                    "from room  r\n" +
                    "where r.id in (   select distinct `room_id` \n" +
                    "                   from `meeting_result` \n" +
                    "                   where `user_id` = :userId);")
    public List<Room> getMeetingInfo(@Param("userId") long userId);

}
