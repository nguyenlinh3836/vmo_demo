package com.example.vmo_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class VmoDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(VmoDemoApplication.class, args);
  }

}
