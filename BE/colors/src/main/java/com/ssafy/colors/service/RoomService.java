package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Room;
import com.ssafy.colors.request.Colorset;
import com.ssafy.colors.request.ResultReq;
import com.ssafy.colors.request.RoomReq;
import com.ssafy.colors.response.MemberRes;
import com.ssafy.colors.response.ResultRes;
import com.ssafy.colors.response.RoomRes;

import java.util.List;
import java.util.Map;

public interface RoomService {
    public RoomRes saveMeetingRoomInfo(RoomReq roomReq);
    public Room checkRoomCode(String code);
    public Room findRandomRoom(long topicId);
    public boolean changeRoomCapacityStatus(long roomId);
    public boolean changeRoomStatus(long hostId, long roomId);
    public boolean saveMeetingResult(ResultReq results);
    public List<ResultRes> getMeetingResult(long roomId);
    public boolean saveTournamentResult(Map<String, Object> params);
    public boolean saveVoteResult(Map<String, Object> params);
    public boolean addVote(long roomId);
    public Object getVoteResult(Map<String, Object> params);
    public Colorset getTop1ColorInfo(Map<String, Object> params);
    public List<Map<String, Object>> getMyPageColorInfo(long userId);
}
