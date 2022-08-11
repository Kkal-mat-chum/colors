package com.ssafy.colors.controller;


import com.ssafy.colors.request.TopicReq;
import com.ssafy.colors.response.Top10TopicDTO;
import com.ssafy.colors.response.TopicDTO;
import com.ssafy.colors.response.TopicRes;
import com.ssafy.colors.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/topic")
@Api(tags = {"토픽을 관리하는 컨트롤러"})
public class TopicController {

    @Autowired
    TopicService topicService;

    // 토픽 생성
    @PostMapping("")
    @ApiOperation(value = "토픽 등록", notes = "작성한 토픽을 등록")
    @ApiImplicitParams({@ApiImplicitParam(name = "title", value = "토픽 제목", required = true), @ApiImplicitParam(name = "writer", value = "토픽 작성자", required = false)})
    public ResponseEntity<HashMap> regisTopic(@RequestBody HashMap<String,Object> params) {
        String title = (String)params.get("title");
        String writer = (String)params.get("writer");
        long topicId = topicService.save(title, writer);
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "success");
        result.put("topicId",topicId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 토픽 삭제
    @DeleteMapping("/{topicId}")
    @ApiOperation(value = "토픽 삭제", notes = "선택한 토픽을 삭제")
    @ApiImplicitParam(name = "topicId", value = "토픽 제목", required = true)
    public ResponseEntity<HashMap> deleteTopic(@PathVariable Long topicId) {
        topicService.delete(topicId);
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "access");
        result.put("topicId", topicId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 토픽 리스트
    @PostMapping("/list")
    @ApiOperation(value = "토픽 리스트 조회", notes = "해당 주차의 토픽을 조회")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "method", value = "정렬 기준", required = true)
            , @ApiImplicitParam(name = "pagenum", value = "몇 페이지 ?", required = false)
            , @ApiImplicitParam(name = "userid", value = "사용자 ?", required = false)})
    public ResponseEntity<TopicRes> getList(Pageable pageable, @RequestBody HashMap<String, Object> params) {
        int userId = (int)params.get("userId");
        String keyword;
        if(!params.containsKey("keyword")){
            keyword = "";
        }else{
            keyword = (String)params.get("keyword");
        }
        TopicRes topicRes = topicService.getList(pageable, (long) userId, keyword);
        return new ResponseEntity<>(topicRes, HttpStatus.OK);
    }


    @GetMapping("/top10")
    @ApiOperation(value = "이번주의 top 10 !!!!", notes = "지난주 토픽중 top 10을 선정")
    public ResponseEntity<TopicRes> gettop10() {
        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,
                        "recommand"));
        TopicRes<Top10TopicDTO> topicRes = topicService.getTop10(pageRequest);
        return new ResponseEntity<>(topicRes, HttpStatus.OK);
    }



}
