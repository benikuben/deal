package ru.neoflex.deal.services;

import ru.neoflex.openapi.dtos.FinishRegistrationRequest;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.LoanOffer;

import java.util.List;

public interface DealService {
    List<LoanOffer> createApplication(LoanApplicationRequest request);

    void applyOffer(LoanOffer loanOfferDTO);

    void finishRegistration(Long applicationId, FinishRegistrationRequest finishRegistrationRequestDTO);
}
