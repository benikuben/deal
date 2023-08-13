package ru.neoflex.deal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.deal.services.DealService;
import ru.neoflex.openapi.controllers.DealApi;
import ru.neoflex.openapi.dtos.FinishRegistrationRequestDTO;
import ru.neoflex.openapi.dtos.LoanApplicationRequestDTO;
import ru.neoflex.openapi.dtos.LoanOfferDTO;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DealController implements DealApi {
    private final DealService dealService;

    /**
     * POST: /deal/application - расчёт возможных условий кредита. Request - LoanApplicationRequestDTO, response - List<LoanOfferDTO>
     */
    @Override
    public ResponseEntity<List<LoanOfferDTO>> createApplication(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        return new ResponseEntity<>(dealService.createApplication(loanApplicationRequestDTO), HttpStatus.OK);
    }

    /**
     * PUT: /deal/offer - Выбор одного из предложений. Request LoanOfferDTO, response void
     */
    @Override
    public ResponseEntity<Void> applyOffer(LoanOfferDTO loanOfferDTO) {
        dealService.applyOffer(loanOfferDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * PUT: /deal/calculate/{applicationId} - завершение регистрации + полный подсчёт кредита. Request - FinishRegistrationRequestDTO, param - Long, response void
     */
    @Override
    public ResponseEntity<Void> finishRegistration(Long applicationId, FinishRegistrationRequestDTO finishRegistrationRequestDTO) {
        dealService.finishRegistration(applicationId, finishRegistrationRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
