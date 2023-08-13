package ru.neoflex.deal.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.openapi.dtos.CreditDTO;
import ru.neoflex.openapi.dtos.LoanApplicationRequestDTO;
import ru.neoflex.openapi.dtos.LoanOfferDTO;
import ru.neoflex.openapi.dtos.ScoringDataDTO;

import java.util.List;

@FeignClient(name = "conveyor", url = "http://localhost:8081", path = "/conveyor")
public interface ConveyorClient {
    @PostMapping("/offers")
    List<LoanOfferDTO> generateOffers(@RequestBody LoanApplicationRequestDTO request);

    @PostMapping("/calculation")
    CreditDTO generateCredit(@RequestBody ScoringDataDTO request);
}
