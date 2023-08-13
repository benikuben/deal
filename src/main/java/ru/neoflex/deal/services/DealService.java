package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.FinishRegistrationRequestDTO;
import ru.neoflex.openapi.dtos.LoanApplicationRequestDTO;
import ru.neoflex.openapi.dtos.LoanOfferDTO;

import java.util.List;

public interface DealService {
    List<LoanOfferDTO> createApplication(LoanApplicationRequestDTO request);
    void applyOffer(LoanOfferDTO loanOfferDTO);
    void finishRegistration(Long applicationId, FinishRegistrationRequestDTO finishRegistrationRequestDTO);
}
