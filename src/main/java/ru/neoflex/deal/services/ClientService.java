package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.repositories.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    /**
     * Если клиент с таким номером и серией паспорта есть в БД,
     * получаем его, проверяя актуальность email из БД при необходимости обновляя,
     * иначе сохранеяем новгого клиента.
     */
    @Transactional
    public Client save(Client client) {
        Optional<Client> optionalClient = clientRepository.findClientByPassportNumberAndSeries(client.getPassport().getNumber(), client.getPassport().getSeries());
        Client clientToSave;
        if (optionalClient.isPresent()) {
            log.info("Client with passport {} {} has already been saved in the database", client.getPassport().getSeries(), client.getPassport().getNumber());
            clientToSave = optionalClient.get();
            if (!clientToSave.getEmail().equals(client.getEmail())) {
                clientToSave.setEmail(client.getEmail());
                log.info("Email of client with passport {} {} was updated to {}", clientToSave.getPassport().getSeries(), clientToSave.getPassport().getNumber(), clientToSave.getEmail());
            }
        } else {
            log.info("Client with passport {} {} has not been previously saved in the database", client.getPassport().getSeries(), client.getPassport().getNumber());
            clientToSave = client;
        }
        return clientRepository.save(clientToSave);
    }

    @Transactional
    public Client update(Client client) {
        return clientRepository.save(client);
    }
}
