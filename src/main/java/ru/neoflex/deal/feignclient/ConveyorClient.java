package ru.neoflex.deal.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.openapi.dtos.Credit;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.LoanOffer;
import ru.neoflex.openapi.dtos.ScoringData;

import java.util.List;

@FeignClient(name = "conveyor", url = "${conveyor.url}", path = "/conveyor")
public interface ConveyorClient {
    @PostMapping("/offers")
    ResponseEntity<List<LoanOffer>> generateOffers(@RequestBody LoanApplicationRequest request);

    @PostMapping("/calculation")
    ResponseEntity<Credit> generateCredit(@RequestBody ScoringData request);
}
