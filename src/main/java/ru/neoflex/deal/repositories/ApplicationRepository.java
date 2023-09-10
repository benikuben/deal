package ru.neoflex.deal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.deal.models.Application;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application save(Application application);

    Optional<Application> findApplicationById(Long id);
}
