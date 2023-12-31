package com.srishti.adminservice;

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

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, AliceNotification> aliceNotificationConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "admin-msg-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(JsonDeserializer.TYPE_MAPPINGS, "msg:com.srishti.adminservice.AliceNotification");
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

    @Bean
    public ConsumerFactory<String, BobNotification> bobNotificationConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "admin-msg-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(JsonDeserializer.TYPE_MAPPINGS, "msg:com.srishti.adminservice.BobNotification");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(BobNotification.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BobNotification>
    bobNotificationKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BobNotification> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(bobNotificationConsumerFactory());
        return factory;
    }
}
