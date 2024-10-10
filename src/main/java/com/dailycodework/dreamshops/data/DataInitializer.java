package com.dailycodework.dreamshops.data;

import com.dailycodework.dreamshops.model.User;
import com.dailycodework.dreamshops.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createDefaultUserIfNotExist();
    }

    private void createDefaultUserIfNotExist() {
        for (int i = 0; i<=5; i++){
            String defaultEmail = "user" + i + "@email.com";
            if (userRepository.existsByEmail(defaultEmail)){
                continue;
            }
            User user = new User();
            user.setFirstName("The user");
            user.setLastName("User" + i);
            user.setEmail(defaultEmail);
            user.setPassword("123456789");
            userRepository.save(user);
            System.out.println("Default user" + i + "created successfully");
        }
    }
}
