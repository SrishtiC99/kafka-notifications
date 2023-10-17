package com.srishti.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/")
public class AdminController {
    @Autowired
    private KafkaTemplate<String, AdminNotification> kafkaTemplate;
    private static final String TOPIC = "admin-msg";

    @GetMapping("publish/")
    public String publish(@RequestParam String name) {
        kafkaTemplate.send(TOPIC, new AdminNotification(name, "msg from"));
        return "Published to all successfully";
    }
}
