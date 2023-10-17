package com.srishti.aliceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alice")
public class AliceController {

    @Autowired
    private KafkaTemplate<String, AliceNotification> kafkaTemplate;

    private static final String TOPIC = "alice-msg";

    @GetMapping("/publish/")
    public String publish(@RequestParam String name, @RequestParam String msg) {
        kafkaTemplate.send(TOPIC, new AliceNotification(name, msg));
        return "Published to Bob & admin";
    }
}
