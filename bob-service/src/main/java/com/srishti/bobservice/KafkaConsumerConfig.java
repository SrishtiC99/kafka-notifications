package com.srishti.bobservice;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, AdminNotification> adminNotificationConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "bob-msg-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(JsonDeserializer.TYPE_MAPPINGS, "msg:com.srishti.bobservice.AdminNotification");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(AdminNotification.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AdminNotification>
    adminNotificationKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AdminNotification> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(adminNotificationConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, AliceNotification> aliceNotificationConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "bob-msg-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(JsonDeserializer.TYPE_MAPPINGS, "msg:com.srishti.bobservice.AliceNotification");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(AliceNotification.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AliceNotification>
    aliceNotificationKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AliceNotification> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(aliceNotificationConsumerFactory());
        return factory;
    }
}
