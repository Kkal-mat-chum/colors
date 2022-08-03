package com.ssafy.colors;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Topic;
import com.ssafy.colors.database.entity.Vote;
import com.ssafy.colors.database.repository.MemberRepository;
import com.ssafy.colors.database.repository.TopicRepository;
import com.ssafy.colors.database.repository.VoteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
class ColorsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    VoteRepository voteRepository ;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void VoteAndTopicTest(){
        // given

        //id password name nickname email
//        Member member1 = new Member();
//        member1.setUserId("kimssafy");
//        member1.setPassword("sasfy");
//        member1.setName("ssafykim");
//        member1.setNickname("Kim");
//        member1.setEmail("kim@ssafy.com");
//
//        Member member2 = new Member();
//        member2.setUserId("Ohssafy");
//        member2.setPassword("sasfy");
//        member2.setName("ssafyOh");
//        member2.setNickname("Oh");
//        member2.setEmail("Oh@ssafy.com");
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//
//
//        // userIntId title regDate year weekNum isDelete
//        for(int i = 0; i<20; i++){
//            topicRepository.save(new Topic(member1.getId(), ("title"+i), LocalDateTime.now().plusDays(i),false));
//        }
//
//        for(int i =0 ; i<10; i++){
//            voteRepository.save(new Vote(member1.getId(), topicRepository.findById((1L)).get(),false));
//        }
//        for(int i =10 ; i<20; i++){
//            voteRepository.save(new Vote(member2.getId(), topicRepository.findById((2L)).get(),false));
//        }
//
//        em.flush();
//        em.clear();
//        // when

        PageRequest pageRequest = PageRequest.of(0,4,Sort.by(Sort.Direction.DESC,"regDate"));
        Page<Topic> page = topicRepository.findTopic(pageRequest, LocalDateTime.now().getYear(), LocalDateTime.now().get(WeekFields.ISO.weekOfYear()));
        //then
        System.out.println("=====================================");
        System.out.println("topics.getTotalElements() = " + page.getTotalElements());
        List<Topic> topicList = page.getContent();
        for(Topic t : topicList){
            System.out.println(t.getTitle() + " "+ t.getRegDate());
        }

        System.out.println("=====================================");
    }

}
