package ru.neoflex.deal.services;

import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Application;

import java.util.List;

public interface ApplicationService {
    @Transactional
    Application save(Application application);

    Application findById(Long id);

    List<Application> findAll();
}
