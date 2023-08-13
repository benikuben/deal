package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.repositories.ApplicationRepository;
import ru.neoflex.deal.util.exceptions.NotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Transactional
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Application findById(Long id) {
        return applicationRepository.findApplicationById(id).orElseThrow(() -> new NotFoundException("Заявка " + id + " не найдена"));
    }
}
