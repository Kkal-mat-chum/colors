package com.ssafy.colors.controller;

import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.database.repository.RoomRepository;
import com.ssafy.colors.enumdata.RoomStatus;
import com.ssafy.colors.enumdata.RoomType;
import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.RoomRes;
import com.ssafy.colors.service.RoomService;
import com.ssafy.colors.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String DUPLICATED = "duplicated";
    private static final String NONDUPLICATED = "not-duplicated";

    @Autowired
    private RoomService roomService;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createMeetingRoom(@RequestBody RoomReq params) {
        System.out.println("[POST] - /room");

        Map<String, Object> result = new HashMap<>();

        RoomRes roomRes = roomService.saveMeetingRoomInfo(params);

        if(roomRes != null) {
            result.put("data", roomRes);
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping()
//    public void createRoomTest(@RequestBody Map<String, Object> params) {
//        System.out.println("[POST] - /room");
//        String userId = (String) params.get("userid");
//        String roomCode = randomStringGenerator.generateRandomPassword(8);
//        Long userKey = memberRepository.findFirstByUserId(userId).getId();
//
//        System.out.println("USER ID - " + userId);
//        System.out.println("ROOM CODE - " + roomCode);
//        System.out.println("ROOM TYPE - " + RoomType.SINGLE);
//        System.out.println("ROOM STATUS - " + RoomStatus.WAITED);
//
//        Room room = Room.builder()
//                .hostId(userKey)
//                .topicId(0L)
//                .roomCode(roomCode)
//                .roomType(RoomType.SINGLE)
//                .cDate(LocalDateTime.now())
//                .status(RoomStatus.WAITED)
//                .build();
//        roomRepository.save(room);
//    }

}
