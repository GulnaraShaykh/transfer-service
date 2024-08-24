package com.example.transferservice.controller;

// src/main/java/com/example/transferservice/controller/TransferController.java

import com.example.transferservice.model.TransferRequest;
import com.example.transferservice.model.ConfirmOperationRequest;
import com.example.transferservice.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody TransferRequest request) {
        String operationId = transferService.transferMoney(request);
        return ResponseEntity.ok().body("{\"operationId\": \"" + operationId + "\"}");
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody ConfirmOperationRequest request) {
        String operationId = transferService.confirmOperation(request);
        return ResponseEntity.ok().body("{\"operationId\": \"" + operationId + "\"}");
    }
}

