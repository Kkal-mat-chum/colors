package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    // 토픽 한개
    Optional<Topic> findById(Long topicId);

    // 토픽 리스트 불러오기(리스트 , 정렬)
    @EntityGraph(attributePaths = {"voters"})
    @Query(value = "select t from Topic t  where t.year = :year and t.weekNum = :weeknum",
            countQuery = "select count(t) from Topic t where t.year = :year and t.weekNum = :weeknum")
    Page<Topic> findTopic(Pageable pageRequest, @Param("year") int year, @Param("weeknum") int weeknum);


}
