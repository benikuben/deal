package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.deal.repositories.CreditRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;

    @Override
    @Transactional
    public Credit save(Credit credit) {
        return creditRepository.save(credit);
    }
}
