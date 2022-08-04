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
        if (findVote.isPresent()) {
            findVote.get().setDelete(false);
        } else {
            Topic topic = topicRepository.findById(voteDTO.getTopicId()).get();
            Vote vote = new Vote();
            vote.setMemberId(voteDTO.getUserId());
            vote.setTopic(topic);
            vote.setDelete(false);
            voteRepository.save(vote);
        }

        return voteRepository.countVote(voteDTO.getTopicId(), voteDTO.getUserId());
    }

    public Long deleteVote(Long topicId,Long userId) {
        Vote findVote = voteRepository.findByTopicIdAndMemberId(topicId, userId).get();
        findVote.setDelete(true);

        return voteRepository.countVote(topicId,userId);
    }
}
