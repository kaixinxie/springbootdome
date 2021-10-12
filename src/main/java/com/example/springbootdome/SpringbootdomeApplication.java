package com.example.springbootdome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootdome.mapper")
public class SpringbootdomeApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(SpringbootdomeApplication.class, args);
  }
  
}
