package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.Application;

public interface AdminService {
    Application getApplicationById(Long applicationId);

    void updateApplicationStatus(Long applicationId, String newStatus);
}
