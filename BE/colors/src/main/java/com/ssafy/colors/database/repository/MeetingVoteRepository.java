package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.MeetingResult;
import com.ssafy.colors.database.entity.MeetingVote;
import com.ssafy.colors.database.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingVoteRepository extends JpaRepository<MeetingVote, Long> {
    public List<MeetingVote> findByMeetingResult(MeetingResult meetingResult);
}
