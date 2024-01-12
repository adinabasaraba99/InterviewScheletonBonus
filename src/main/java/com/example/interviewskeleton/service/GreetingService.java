package com.example.interviewskeleton.service;

import com.example.interviewskeleton.config.GreetingConfig;
import com.example.interviewskeleton.entity.Greeting;
import com.example.interviewskeleton.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class GreetingService {

    private final GreetingConfig greetingConfig;

    private GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String generateGreeting(String name, String locale) {
        String timeOfDay = getTimeOfDay();

        Map<String, String> messagesByTime = getMessageForTime(timeOfDay, locale);

        String greetingMessage = messagesByTime.get(locale);
        if (greetingMessage == null) {
            greetingMessage = messagesByTime.get("en");
        }

        return greetingMessage.replace("{name}", name);
    }

    private String getTimeOfDay() {
        int hour = java.time.LocalTime.now().getHour();
        if (hour >= 6 && hour < 12) {
            return "morning";
        } else if (hour >= 12 && hour < 18) {
            return "afternoon";
        } else {
            return "evening";
        }
    }

    private Map<String, String> getMessageForTime(String time, String locale) {
        return switch (time) {
            case "afternoon" -> greetingConfig.getAfternoon();
            case "evening" -> greetingConfig.getEvening();
            default -> greetingConfig.getMorning();
        };
    }
}


