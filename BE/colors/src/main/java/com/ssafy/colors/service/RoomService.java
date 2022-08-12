package com.ssafy.colors.service;

import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.MemberRes;
import com.ssafy.colors.response.RoomRes;

import java.util.List;

public interface RoomService {
    public RoomRes saveMeetingRoomInfo(RoomReq roomReq);
    public boolean checkRoomCode(String code);
    public List<String> findRandomRoomList(long topicId);
    public boolean changeRoomStatus(long hostId, long roomId);
}
