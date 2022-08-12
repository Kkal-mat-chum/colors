package com.ssafy.colors.controller;

import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.RoomRes;
import com.ssafy.colors.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

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

    @PostMapping("/join/group")
    public ResponseEntity<Map<String, Object>> joinGroupMeeting(@RequestBody Map<String, Object> params) {
        System.out.println("[POST - /room/join/group]");

        Map<String, Object> result = new HashMap<>();
        String roomCode = (String) params.get("roomcode");

        if(roomService.checkRoomCode(roomCode)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/join/random")
    public ResponseEntity<Map<String, Object>> joinRandomMeeting(@RequestBody Map<String, Object> params) {
        System.out.println("[POST - /room/join/random]");

        Map<String, Object> result = new HashMap<>();
        Long topicId = Long.parseLong(params.get("topic_id").toString());

        List<String> roomList = roomService.findRandomRoomList(topicId);

        if(!roomList.isEmpty()) {
            result.put("data", roomList);
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<Map<String, Object>> changeRoomStatus(@RequestBody Map<String, Object> params) {
        System.out.println("[PUT] - /room/status");
        Long roomId = Long.parseLong(params.get("roomid").toString());
        Long hostId = Long.parseLong(params.get("hostid").toString());

        Map<String, Object> result = new HashMap<>();

        if(roomService.changeRoomStatus(hostId, roomId)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/result")
    public ResponseEntity<Map<String, Object>> saveMeetingResult(@RequestBody String param) {
        System.out.println("[POST - /room/result");

        Map<String, Object> result = new HashMap<>();

        if(true) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
