package ru.neoflex.deal.services;

import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Client;

public interface ClientService {
    @Transactional
    Client save(Client client);

    @Transactional
    Client update(Client client);
}
