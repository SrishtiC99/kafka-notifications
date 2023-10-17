package com.srishti.bobservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bob")
public class BobController {

    @Autowired
    private KafkaTemplate<String, BobNotification> kafkaTemplate;

    private static String TOPIC = "bob-msg" ;

    @PostMapping("/publish/")
    private String publish(@RequestBody BobNotification notification) {
        kafkaTemplate.send(TOPIC, notification);
        return notification.getName() + ": " + notification.getMsg();
    }
}
