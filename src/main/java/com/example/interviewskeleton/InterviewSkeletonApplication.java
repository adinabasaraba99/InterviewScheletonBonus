package com.example.interviewskeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.yaml")
public class InterviewSkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewSkeletonApplication.class, args);
    }

}
