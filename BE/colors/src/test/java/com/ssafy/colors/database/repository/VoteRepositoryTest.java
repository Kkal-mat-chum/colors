package com.ssafy.colors.database.repository;

import com.ssafy.colors.database.entity.Member;
import com.ssafy.colors.database.entity.Topic;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class VoteAndTopicRepositoryTest {

    @Autowired
    VoteRepository voteRepository ;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void VoteAndTopicTest(){
         // given

        //id password name nickname email
        Member member1 = new Member();
        member1.setUserId("kimssafy");
        member1.setPassword("sasfy");
        member1.setName("ssafykim");
        member1.setNickname("Kim");
        member1.setEmail("kim@ssafy.com");

        Member member2 = new Member();
        member2.setUserId("Ohssafy");
        member2.setPassword("sasfy");
        member2.setName("ssafyOh");
        member2.setNickname("Oh");
        member2.setEmail("Oh@ssafy.com");
        memberRepository.save(member1);
        memberRepository.save(member2);


//        Topic topic1 = new Topic();


        // when
        Optional<Member> findbyid1 = memberRepository.findById(0L);



        //then

        Assertions.assertThat(findbyid1).isEqualTo(member1);
    }

}