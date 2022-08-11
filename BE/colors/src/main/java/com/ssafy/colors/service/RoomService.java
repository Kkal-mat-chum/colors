package com.ssafy.colors.service;

import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.MemberRes;
import com.ssafy.colors.response.RoomRes;

public interface RoomService {
    public RoomRes saveMeetingRoomInfo(RoomReq roomReq);
}
