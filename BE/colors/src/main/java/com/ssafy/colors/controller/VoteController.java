package com.ssafy.colors.controller;

import com.ssafy.colors.request.VoteDTO;
import com.ssafy.colors.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
@Api(tags = {"토픽의 추천 정보를 관리하는 컨트롤러"})
public class VoteController {

    @Autowired
    VoteService voteService;

    // 생성
    @PostMapping("")
    @ApiOperation(value = "토픽 추천", notes ="토픽을 추천 ~")
    public ResponseEntity<Long> registVote(@RequestBody VoteDTO vote) {
        Long count = voteService.saveVote(vote);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    // 삭제
    @DeleteMapping("/{topicId}/{userId}")
    @ApiOperation(value = "토픽 추천 취소", notes ="추천 취소 ~")
    @ApiImplicitParam(name ="voteId", value="토픽 추천 id", required = true)
    public ResponseEntity<Long> deleteVote(@PathVariable Long topicId, @PathVariable Long userId){
        Long cnt = voteService.deleteVote(topicId, userId);

        return new ResponseEntity<>(cnt ,HttpStatus.OK);
    }

}
