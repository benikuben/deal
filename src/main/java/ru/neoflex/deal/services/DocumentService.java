package ru.neoflex.deal.services;

public interface DocumentService {
    void sendDocuments(Long applicationId);

    void signDocuments(Long applicationId);

    void verifyCode(Long applicationId, Integer sesCode);
}
