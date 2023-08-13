package ru.neoflex.deal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.neoflex.deal.models.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client save(Client client);

    @Query(nativeQuery = true, value = "SELECT * from client where passport_id->>'number' like :number and passport_id->>'series'like :series")
    Optional<Client> findClientByPassportNumberAndSeries(@Param("number") String number, @Param("series") String series);
}
