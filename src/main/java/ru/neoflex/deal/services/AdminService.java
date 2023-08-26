package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.ApplicationDTO;

public interface AdminService {
    ApplicationDTO getApplicationById(Long applicationId);

    void updateApplicationStatus(Long applicationId, String newStatus);
}
