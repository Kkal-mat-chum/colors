package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.database.repository.RoomRepository;
import com.ssafy.colors.database.repository.TopicRepository;
import com.ssafy.colors.enumdata.RoomStatus;
import com.ssafy.colors.enumdata.RoomType;
import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.RoomRes;
import com.ssafy.colors.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Override
    public RoomRes saveMeetingRoomInfo(RoomReq roomReq) {
        System.out.println("Enter RoomService - saveMeetingRoomInfo()");

        Member host = memberRepository.findById(roomReq.getHostid()).get();
        Topic selectedTopic = null;

        RoomType roomType = null;
        if (roomReq.getRoomtype().equals("single")) {
            roomType = RoomType.SINGLE;
        } else if (roomReq.getRoomtype().equals("group")) {
            roomType = RoomType.GROUP;
        } else if (roomReq.getRoomtype().equals("random")) {
            roomType = RoomType.RANDOM;
            selectedTopic = topicRepository.findById(roomReq.getTopicid()).get();
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
                    //.hostId(roomReq.getHostid())
                    .host(host)
                    //.topicId(roomReq.getTopicid())
                    .topic(selectedTopic)
                    .roomCode(randomCode)
                    .roomType(roomType)
                    .cDate(LocalDateTime.now())
                    .status(RoomStatus.WAITED)
                    .build();
            try {
                roomRepository.save(room);

                RoomRes result = RoomRes.builder()
                        .roomid(room.getId())
                        .hostid(room.getHost().getId())
                        .roomcode(room.getRoomCode())
                        .title(selectedTopic == null ? null : room.getTopic().getTitle())
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

    @Override
    public boolean checkRoomCode(String code) {
        Room room = roomRepository.findFirstByRoomCodeAndStatus(code, RoomStatus.WAITED);

        if (room != null) return true;
        else return false;
    }

    @Override
    public List<String> findRandomRoomList(long topicId) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        List<String> result = new ArrayList<>();

        topic.ifPresent(t -> {
            RoomType type = RoomType.RANDOM;
            RoomStatus status = RoomStatus.WAITED;
            List<Room> rooms = roomRepository.findRoomByTopicAndRoomTypeAndStatus(topic.get(), type, status);

            if (!rooms.isEmpty()) {
                for (Room room : rooms) {
                    result.add(room.getRoomCode());
                }
            }
        });

        return result;
    }

    @Override
    public boolean changeRoomStatus(long hostId, long roomId) {
        Optional<Member> host = memberRepository.findById(hostId);

        if(host.isPresent()) {
            Room room = roomRepository.findByIdAndHost(roomId, host.get());
            if(room == null) return false;

            int result = 0;

            if(room.getStatus().equals(RoomStatus.WAITED)) {
                result = roomRepository.updateRoomStatus(roomId, host.get(), RoomStatus.STARTED);
            } else if(room.getStatus().equals(RoomStatus.STARTED)) {
                result = roomRepository.updateRoomStatus(roomId, host.get(), RoomStatus.CLOSED);
            }

            return result > 0;
        } else {
            return false;
        }

    }
}
