package com.srishti.aliceservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "admin-msg", groupId = "alice-msg-group",
            containerFactory = "adminNotificationKafkaListenerFactory")
    public void consumeAdminNotification(AdminNotification notification) {
        System.out.println("Alice Service: " + notification.getMsg() + " " + notification.getName());
    }

}
