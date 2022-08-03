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




    public void save(String title, String writer) {
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setUserIntId(memberRepository.findFirstByUserId(writer).getId());
        topic.setIsDeleted(false);
        topic.setRegDate(LocalDateTime.now());
        topic.setWeekNum(LocalDate.now().get(WeekFields.ISO.weekOfYear()));

        topicRepository.save(topic);
    }

    public void delete(Long topicid) {
        Optional<Topic> findtopic = topicRepository.findById(topicid);
        if (findtopic.isPresent()) {
            findtopic.get().setIsDeleted(true);
        }
    }

    public TopicRes getList(String method, int pagenum,Long userid) {

        PageRequest pageRequest = PageRequest.of(pagenum, 10, Sort.by(Sort.Direction.ASC, method));
        int year = LocalDate.now().getYear();
        int weeknum = LocalDate.now().get(WeekFields.ISO.weekOfYear());
        Page<Topic> topic = topicRepository.findTopic(pageRequest, year, weeknum);
//        List<TopicDTO> map = topic.map(t -> new TopicDTO(t.getTitle(), t.getVoters().contains(new VoteDTO(userid, t.getId())), t.getVoters().size())).getContent();
        List<TopicDTO> map = topic.map(t -> new TopicDTO(t.getTitle(), check(t.getVoters(),new VoteDTO(userid, t.getId())), t.getVoters().size())).getContent();
        for(TopicDTO t : map){
            System.out.println(t.getTitle() + " " + t.getCnt() + " " + t.isRecommend());
        }
        System.out.println("topic.getTotalElements() = " + topic.getTotalElements());
        return new TopicRes((int)topic.getTotalElements(),map);

    }

    public boolean check(List<Vote> list , VoteDTO dto){
        for(Vote v : list){
            System.out.println(v.getId() + " " + v.getMemberId());
            System.out.println(dto.getTopicId() + " " + dto.getUserId());
            if(v.getId().equals(dto.getTopicId()) && v.getMemberId().equals(dto.getUserId())){
                return true;
            }
        }
        return false;
    }

}
