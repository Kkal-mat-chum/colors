package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.database.entity.Vote;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.database.repository.TopicRepository;
import com.ssafy.colors.database.repository.VoteRepository;
import com.ssafy.colors.request.VoteDTO;
import com.ssafy.colors.response.TopicDTO;
import com.ssafy.colors.response.TopicRes;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private VoteRepository voteRepository;


    public long save(String title, String writer) {
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setUserIntId(memberRepository.findFirstByUserId(writer).getId());
        topic.setIsDeleted(false);
        topic.setRegDate(LocalDateTime.now());
        topic.setWeekNum(LocalDate.now().get(WeekFields.ISO.weekOfYear()));

        topicRepository.save(topic);

        return topic.getId();
    }

    public void delete(Long topicid) {
        Optional<Topic> findtopic = topicRepository.findById(topicid);
        if (findtopic.isPresent()) {
            findtopic.get().setIsDeleted(true);
        }
    }

    public TopicRes getList(Pageable pageRequest, Long userId, String keyword) {

        LocalDateTime now = LocalDateTime.now();
        Page<Topic> topic = topicRepository.findTopic(pageRequest, now.getYear(), now.get(WeekFields.ISO.weekOfYear()), keyword);
        List<TopicDTO> map = topic.map(t -> new TopicDTO(t.getId(), t.getTitle(), t.check(new VoteDTO(userId, t.getId())), t.count())).getContent();
        return new TopicRes((int) topic.getTotalPages(), map);

    }
}
