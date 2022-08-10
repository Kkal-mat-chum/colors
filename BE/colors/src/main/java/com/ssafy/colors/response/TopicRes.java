package com.ssafy.colors.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TopicRes<T> {

    int maxpage ;
    long topiccnt;
    List<T> topics;

}
