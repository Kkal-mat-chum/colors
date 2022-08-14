package com.ssafy.colors.controller;

import com.ssafy.colors.request.Colorset;
import com.ssafy.colors.request.ResultReq;
import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.ResultRes;
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
        Long topicId = Long.parseLong(params.get("topicid").toString());

        String roomList = roomService.findRandomRoom(topicId);

        if(!roomList.isEmpty()) {
            result.put("data", roomList);
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping("/join/random")
//    public ResponseEntity<Map<String, Object>> joinRandomMeeting(@RequestBody Map<String, Object> params) {
//        System.out.println("[POST - /room/join/random]");
//
//        Map<String, Object> result = new HashMap<>();
//        Long topicId = Long.parseLong(params.get("topic_id").toString());
//
//        List<String> roomList = roomService.findRandomRoomList(topicId);
//
//        if(!roomList.isEmpty()) {
//            result.put("data", roomList);
//            result.put("message", SUCCESS);
//        } else {
//            result.put("message", FAIL);
//        }
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @PutMapping("/capacity")
    public ResponseEntity<Map<String, Object>> changeRoomCapacityStatus(@RequestBody Map<String, Object> params) {
        System.out.println("[PUT] - /room/capacity");
        Long roomId = Long.parseLong(params.get("roomid").toString());

        Map<String, Object> result = new HashMap<>();

        if(roomService.changeRoomCapacityStatus(roomId)) {
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

    // 미팅에서 선택한 색상 저장
    @PostMapping("/result")
    public ResponseEntity<Map<String, Object>> saveMeetingResult(@RequestBody ResultReq params) {
        System.out.println("[POST - /room/result");

        Map<String, Object> result = new HashMap<>();

        if(roomService.saveMeetingResult(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 투표지 생성을 위해 미팅 결과 가져오기
    @PostMapping("/getresult")
    public ResponseEntity<Map<String, Object>> getMeetingResult(@RequestBody Map<String, Object> params) {
        System.out.println("[POST] - /room/getresult");

        Map<String, Object> result = new HashMap<>();
        Long roomId = Long.parseLong(params.get("roomid").toString());
        System.out.println(roomId);

        List<ResultRes> resultList = roomService.getMeetingResult(roomId);

        if(!resultList.isEmpty()) {
            result.put("data", resultList);
            result.put("cnt", resultList.size());
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 개인 룸의 투표 결과 저장
    @PutMapping("/vote")
    public ResponseEntity<Map<String, Object>> saveVoteResultForTournament(@RequestBody Map<String, Object> params) {
        System.out.println("[PUT] - /room/vote");
        System.out.println(params);

        Map<String, Object> result = new HashMap<>();

        if(roomService.saveTournamentResult(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 그룹, 랜덤 미팅 룸의 투표 결과 저장
    @PostMapping("/vote")
    public ResponseEntity<Map<String, Object>> saveVoteResult(@RequestBody Map<String, Object> params) {
        System.out.println("[POST] - /room/vote");
        System.out.println(params);

        Map<String, Object> result = new HashMap<>();

        if(roomService.saveVoteResult(params)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/votesum")
    public ResponseEntity<Map<String, Object>> sumVote(@RequestBody Map<String, Object> params) {
        System.out.println("[PUT] - /room/votesum");
        Long roomId = Long.parseLong(params.get("roomid").toString());

        Map<String, Object> result = new HashMap<>();

        if(roomService.addVote(roomId)) {
            result.put("message", SUCCESS);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/vote/result")
    public ResponseEntity<Map<String, Object>> getVoteResult(@RequestBody Map<String, Object> params) {
        System.out.println("[POST] - /room/vote/result");

        Map<String, Object> result = new HashMap<>();
        Object outputData = roomService.getVoteResult(params);
        Colorset colorset = roomService.getTop1ColorInfo(params);

        if(outputData != null && colorset != null) {
            result.put("message", SUCCESS);
            result.put("data", outputData);
            result.put("top1", colorset);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/mypage")
    public ResponseEntity<Map<String, Object>> getMyPageData(@RequestBody Map<String, Object> params) {
        System.out.println("[GET] - /room/mypage");

        Map<String, Object> result = new HashMap<>();
        Long userId = Long.parseLong(params.get("userid").toString());

        List<Map<String, Object>> output = roomService.getMyPageColorInfo(userId);

        if(output != null) {
            result.put("message", SUCCESS);
            result.put("data", output);
        } else {
            result.put("message", FAIL);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
