package com.ssafy.colors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class ColorsApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "classpath:aws.yml";

    //    public static void main(String[] args) {
//        SpringApplication.run(ColorsApplication.class, args);
//    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ColorsApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}
