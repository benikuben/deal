package ru.neoflex.deal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.deal.services.DocumentService;
import ru.neoflex.openapi.controllers.DocumentApi;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deal")
public class DocumentsController implements DocumentApi {
    private final DocumentService documentService;

    @Override
    public ResponseEntity<Void> sendDocuments(Long applicationId) {
        documentService.sendDocuments(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> signDocuments(Long applicationId) {
        documentService.signDocuments(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> verifyCode(Long applicationId, Integer sesCode) {
        documentService.verifyCode(applicationId, sesCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
