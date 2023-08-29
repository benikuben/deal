package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.EmailMessage;

public interface KafkaProducer {
    void produceMessage(EmailMessage emailMessage);
}
