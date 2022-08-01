package com.ssafy.colors.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {

    private String address;
    private String title;
    private String message;
}
