package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.database.repository.RoomRepository;
import com.ssafy.colors.enumdata.RoomStatus;
import com.ssafy.colors.enumdata.RoomType;
import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.RoomRes;
import com.ssafy.colors.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Override
    public RoomRes saveMeetingRoomInfo(RoomReq roomReq) {
        System.out.println("Enter RoomService - saveMeetingRoomInfo()");

        RoomType roomType = null;
        if (roomReq.getRoomtype().equals("single")) {
            roomType = RoomType.SINGLE;
        } else if (roomReq.getRoomtype().equals("group")) {
            roomType = RoomType.GROUP;
        } else if (roomReq.getRoomtype().equals("random")) {
            roomType = RoomType.RANDOM;
        } else {
            System.out.println("잘못된 파라미터입니다.");
            return null;
        }

        // 랜덤으로 생성된 방 코드가 중복될 경우 최대 5회까지 시도
        String randomCode = null;
        boolean issued = false;

        for (int i = 0; i < 5; i++) {
            randomCode = randomStringGenerator.generateRandomPassword(8).toUpperCase(Locale.ROOT);
            Room tempRoom = roomRepository.findFirstByRoomCodeAndStatus(randomCode, RoomStatus.WAITED);

            if (tempRoom == null) {
                issued = true;
                break;
            } else continue;
        }

        System.out.println("RANDOM CODE : " + randomCode);
        System.out.println("ISSUED : " + issued);

        // 방 코드를 정상 발급 받은 경우
        if (issued) {
            Room room = Room.builder()
                    .hostId(roomReq.getHostid())
                    .topicId(roomReq.getTopicid())
                    .roomCode(randomCode)
                    .roomType(roomType)
                    .cDate(LocalDateTime.now())
                    .status(RoomStatus.WAITED)
                    .build();
            try {
                roomRepository.save(room);

                RoomRes result = RoomRes.builder()
                        .roomid(room.getId())
                        .hostid(room.getHostId())
                        .roomcode(room.getRoomCode())
                        .title(null)
                        .roomtype(room.getRoomType().toString().toLowerCase())
                        .status(room.getStatus().toString().toLowerCase())
                        .build();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        // 정상적으로 발급받지 못한 경우(5회 중복)
        else {
            return null;
        }
    }
}
