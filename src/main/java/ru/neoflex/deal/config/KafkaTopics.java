package ru.neoflex.deal.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile(value = "local")
public class KafkaTopics {
    public static final String FINISH_REGISTRATION = "finish-registration";
    public static final String CREATE_DOCUMENTS = "create-documents";
    public static final String SEND_DOCUMENTS = "send-documents";
    public static final String SEND_SES = "send-ses";
    public static final String CREDIT_ISSUED = "credit-issued";
    public static final String APPLICATION_DENIED = "application-denied";

    @Bean
    public NewTopic finishRegistrationTopic() {
        return TopicBuilder
                .name(FINISH_REGISTRATION)
                .partitions(3)
                .replicas(1).build();
    }

    @Bean
    public NewTopic createDocumentsTopic() {
        return TopicBuilder
                .name(CREATE_DOCUMENTS)
                .partitions(3)
                .replicas(1).build();
    }

    @Bean
    public NewTopic sendDocumentsTopic() {
        return TopicBuilder
                .name(SEND_DOCUMENTS)
                .partitions(3)
                .replicas(1).build();
    }

    @Bean
    public NewTopic sendSesTopic() {
        return TopicBuilder
                .name(SEND_SES)
                .partitions(3)
                .replicas(1).build();
    }

    @Bean
    public NewTopic creditIssuedTopic() {
        return TopicBuilder
                .name(CREDIT_ISSUED)
                .partitions(3)
                .replicas(1).build();
    }

    @Bean
    public NewTopic applicationDeniedTopic() {
        return TopicBuilder
                .name(APPLICATION_DENIED)
                .partitions(3)
                .replicas(1).build();
    }
}
