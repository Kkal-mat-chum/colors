package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.enumdata.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findFirstByRoomCodeAndStatus(String code, RoomStatus status);
}
