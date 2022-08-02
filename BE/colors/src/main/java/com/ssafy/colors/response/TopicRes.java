package com.ssafy.colors.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicRes<T> {

    int cnt ;

    T topics;

}
