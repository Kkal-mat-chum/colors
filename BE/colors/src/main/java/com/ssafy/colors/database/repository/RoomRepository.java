package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.enumdata.RoomStatus;
import com.ssafy.colors.enumdata.RoomType;
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

    public List<Room> findRoomByTopicAndRoomTypeAndStatus(Topic topic, RoomType type, RoomStatus status);

    public Room findByIdAndHost(Long id, Member host);

    @Modifying
    @Transactional
    @Query("UPDATE Room as r " +
            "SET r.status = :status " +
            "Where r.host = :host And r.id = :roomId")
    public int updateRoomStatus(@Param("roomId") Long roomId,
                                @Param("host") Member host,
                                @Param("status") RoomStatus status);
}
