package com.ssafy.colors.service;

import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.request.VoteDTO;
import com.ssafy.colors.database.entity.Vote;
import com.ssafy.colors.database.repository.TopicRepository;
import com.ssafy.colors.database.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    TopicRepository topicRepository;

    public Long saveVote(VoteDTO voteDTO) {
        Optional<Vote> findVote = voteRepository.findByTopicIdAndMemberId(voteDTO.getTopicId(), voteDTO.getUserId());
        Long votecnt = 0L;
        Topic topic = topicRepository.findById(voteDTO.getTopicId()).get();
        topic.setRecommand(topic.getRecommand() + 1);
        if (findVote.isPresent()) {
            findVote.get().setDelete(false);
        } else {
            Vote vote = new Vote();
            vote.setMemberId(voteDTO.getUserId());
            vote.setTopic(topic);
            vote.setDelete(false);
            voteRepository.save(vote);
        }

//        return voteRepository.countVote(voteDTO.getTopicId(), voteDTO.getUserId());
        return topic.getRecommand();
    }

    public Long deleteVote(Long topicId, Long userId) {
        Vote findVote = voteRepository.findByTopicIdAndMemberId(topicId, userId).get();
        findVote.setDelete(true);
        Topic topic = topicRepository.findById(topicId).get();
        topic.setRecommand(topic.getRecommand()-1);
        return topic.getRecommand();
    }
}
