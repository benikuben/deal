package ru.neoflex.deal.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Test
    void updateApplicationStatus() {
        assertThrows(IllegalArgumentException.class, () -> adminService.updateApplicationStatus(1L, "Invalid status"));
    }
}