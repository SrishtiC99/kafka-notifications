package com.srishti.adminservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "alice-msg", groupId = "admin-msg-group",
            containerFactory = "aliceNotificationKafkaListenerFactory")
    public void consumeAliceNotification(AliceNotification notification) {
        System.out.println("Admin Service: " + notification.getMsg() + " " + notification.getName());
    }
}
