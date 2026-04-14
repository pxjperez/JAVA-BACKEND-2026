package edu.cibertec.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cibertec.entity.CursoEntity;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public KafkaConsumer<String, CursoEntity> kafkaConsumer() {
        return new KafkaConsumer<>(kafkaProperties.buildConsumerProperties());
    }
    
}
