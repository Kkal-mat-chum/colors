package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    public Optional<Vote> findByTopicIdAndUserId(@Param("topicId") Long topicid, @Param("userId") Long userid);
}
