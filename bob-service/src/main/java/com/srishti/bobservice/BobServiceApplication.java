package com.srishti.bobservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class BobServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BobServiceApplication.class, args);
    }
}
