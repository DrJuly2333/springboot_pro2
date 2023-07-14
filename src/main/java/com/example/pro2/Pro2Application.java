package com.example.pro2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.pro2.mapper")
public class Pro2Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro2Application.class, args);
    }

}
