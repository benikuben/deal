package ru.neoflex.deal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.deal.models.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    Credit save(Credit credit);
}
