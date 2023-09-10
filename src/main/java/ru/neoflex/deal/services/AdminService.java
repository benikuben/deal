package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.Application;

import java.util.List;

public interface AdminService {
    Application getApplicationById(Long applicationId);

    void updateApplicationStatus(Long applicationId, String newStatus);

    List<Application> getAllApplications();
}
