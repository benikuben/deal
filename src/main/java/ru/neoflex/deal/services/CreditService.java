package ru.neoflex.deal.services;

import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Credit;

public interface CreditService {
    @Transactional
    Credit save(Credit credit);
}
