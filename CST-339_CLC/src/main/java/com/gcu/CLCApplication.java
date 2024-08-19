package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.gcu.models")
@ComponentScan(basePackages = "com.gcu")
public class CLCApplication {
    public static void main(String[] args) {
        SpringApplication.run(CLCApplication.class, args);
    }
}
