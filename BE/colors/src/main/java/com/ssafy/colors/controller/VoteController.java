package com.ssafy.colors.controller;

import com.ssafy.colors.request.VoteDTO;
import com.ssafy.colors.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    // 생성
    @GetMapping("")
    public ResponseEntity<String> registVote(@RequestBody VoteDTO vote) {
        voteService.saveVote(vote);

        return new ResponseEntity<>("access", HttpStatus.OK);
    }
    // 삭제
    @DeleteMapping("/{voteid}")
    public ResponseEntity<String> deleteVote(@PathVariable Long voteid){
        voteService.deleteVote(voteid);

        return new ResponseEntity<>("access",HttpStatus.OK);
    }

}
