package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    @Query("select count(v) from Vote v where v.topic.id = :topicId and v.memberId = :userId and v.isDelete = false")
    public Long countVote(@Param("topicId") Long topicId, @Param("userId") Long userId);

    public Optional<Vote> findByTopicIdAndMemberId(@Param("topicId") Long topicid, @Param("userId") Long userid);
}
