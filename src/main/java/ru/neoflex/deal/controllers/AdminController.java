package ru.neoflex.deal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.deal.services.AdminService;
import ru.neoflex.openapi.controllers.AdminApi;
import ru.neoflex.openapi.dtos.Application;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deal")
public class AdminController implements AdminApi {
    private final AdminService adminService;

    @Override
    public ResponseEntity<Application> getApplicationById(Long applicationId) {
        return new ResponseEntity<>(adminService.getApplicationById(applicationId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateApplicationStatus(Long applicationId, String body) {
        adminService.updateApplicationStatus(applicationId, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Application>> getAllApplications() {
        return new ResponseEntity<>(adminService.getAllApplications(), HttpStatus.OK);
    }
}
