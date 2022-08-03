package com.ssafy.colors.controller;


import com.ssafy.colors.response.TopicRes;
import com.ssafy.colors.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicService topicService;


    // 토픽 생성
    @PostMapping("")
    public ResponseEntity<String> regisTopic(String title, String writer) {
        topicService.save(title, writer);

        return new ResponseEntity<>("access", HttpStatus.OK);
    }

    // 토픽 삭제
    @DeleteMapping("/{topicid}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long topicid) {
        topicService.delete(topicid);

        return new ResponseEntity<>("access", HttpStatus.OK);
    }

    // 토픽 리스트
    @GetMapping("/{userid}/{method}/{pagenum}")
    public ResponseEntity<TopicRes> getList(@PathVariable String method, @PathVariable int pagenum, @PathVariable Long userid) {

        topicService.getList(method, pagenum,userid);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
