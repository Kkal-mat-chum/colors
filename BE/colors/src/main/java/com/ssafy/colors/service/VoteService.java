package com.ssafy.colors.service;

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

    public void saveVote(VoteDTO voteDTO) {
        Optional<Vote> findVote = voteRepository.findByTopicIdAndMemberId(voteDTO.getTopicId(), voteDTO.getUserId());
        if (findVote.isPresent()) {
            findVote.get().setDelete(false);
        } else {
            Vote vote = new Vote();
            vote.setMemberId(voteDTO.getUserId());
            vote.setTopic(topicRepository.findById(voteDTO.getTopicId()).get());
            vote.setDelete(false);
            voteRepository.save(vote);
        }
    }

    public void deleteVote(Long voteid) {
        voteRepository.findById(voteid).get().setDelete(true);

    }
}
