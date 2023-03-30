package com.example.hncs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.example.hncs.mapper")
public class HncsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HncsApplication.class, args);
    }

}
