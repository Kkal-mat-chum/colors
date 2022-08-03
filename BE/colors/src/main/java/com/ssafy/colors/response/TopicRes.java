package com.ssafy.colors.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TopicRes {

    int maxpage ;

    List<TopicDTO> topics;

}
