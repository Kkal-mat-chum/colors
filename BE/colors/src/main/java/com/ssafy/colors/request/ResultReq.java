package com.ssafy.colors.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultReq {
    private Long roomid;
    private Long userid;
    private List<Colorset> colorset;
}
