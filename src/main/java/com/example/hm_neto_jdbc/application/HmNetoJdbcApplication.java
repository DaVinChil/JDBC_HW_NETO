package com.example.hm_neto_jdbc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.hm_neto_jdbc")
public class HmNetoJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmNetoJdbcApplication.class, args);
    }

}
