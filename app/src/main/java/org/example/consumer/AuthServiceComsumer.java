package org.example.consumer;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.example.entities.UserInfo;


@Service
public class AuthServiceComsumer {
    

    private UserRepository userRepository;

    @Autowired
    public AuthServiceComsumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfo userInfo) {
        try {
            userRepository.save(userInfo);
            System.out.println("User info saved: " + userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
