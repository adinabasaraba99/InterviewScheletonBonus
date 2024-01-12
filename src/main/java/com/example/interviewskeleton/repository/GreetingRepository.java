package com.example.interviewskeleton.repository;

import com.example.interviewskeleton.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

    Optional<Greeting> findByName(String username);

}
