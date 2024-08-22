package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(topics = "order_topic", groupId = "user-group")
    public void listen(String message) {
        System.out.println("Received Message in group user-group: " + message);
    }
}
