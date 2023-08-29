package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.repositories.ApplicationRepository;
import ru.neoflex.deal.exceptions.NotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    @Transactional
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application findById(Long id) {
        return applicationRepository.findApplicationById(id).orElseThrow(() -> new NotFoundException("Заявка " + id + " не найдена"));
    }
}
