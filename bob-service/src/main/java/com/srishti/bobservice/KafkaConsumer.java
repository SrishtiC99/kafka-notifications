package com.srishti.bobservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "admin-msg", groupId = "bob-msg-group",
            containerFactory = "adminNotificationKafkaListenerFactory")
    public void consumeAdminNotification(AdminNotification notification) {
        System.out.println("Bob Service: " + notification.getMsg() + " " + notification.getName());
    }

    @KafkaListener(topics = "alice-msg", groupId = "bob-msg-group",
            containerFactory = "aliceNotificationKafkaListenerFactory")
    public void consumeAliceNotification(AliceNotification notification) {
        System.out.println("Bob Service: " + notification.getMsg() + " " + notification.getName());
    }

}
