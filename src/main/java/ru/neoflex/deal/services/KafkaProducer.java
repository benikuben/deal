package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.neoflex.openapi.dtos.EmailMessage;
import ru.neoflex.openapi.dtos.Theme;

import static ru.neoflex.deal.config.KafkaTopics.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {

    private final KafkaTemplate<Integer, EmailMessage> kafkaTemplate;

    public void produceMessage(EmailMessage emailMessage) {
        Theme currentTheme = emailMessage.getTheme();
        switch (currentTheme) {
            case FINISH_REGISTRATION -> kafkaTemplate.send(FINISH_REGISTRATION, emailMessage);
            case CREATE_DOCUMENTS -> kafkaTemplate.send(CREATE_DOCUMENTS, emailMessage);
            case SEND_DOCUMENTS -> kafkaTemplate.send(SEND_DOCUMENTS, emailMessage);
            case SEND_SES -> kafkaTemplate.send(SEND_SES, emailMessage);
            case CREDIT_ISSUED -> kafkaTemplate.send(CREDIT_ISSUED, emailMessage);
            case APPLICATION_DENIED -> kafkaTemplate.send(APPLICATION_DENIED, emailMessage);
        }
    }
}

