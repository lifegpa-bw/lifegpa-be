package com.lambdaschool.lifegpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LifegpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifegpaApplication.class, args);
    }

}
