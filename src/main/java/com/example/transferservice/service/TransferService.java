
package com.example.transferservice.service;

import com.example.transferservice.model.TransferRequest;
import com.example.transferservice.model.ConfirmOperationRequest;
import com.example.transferservice.repository.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public String transferMoney(TransferRequest request) {
        // Логика перевода денег (например, взаимодействие с банком)
        String operationId = generateOperationId();

        // Логируем операцию
        boolean success = true; // предположим, что операция успешна
        transferRepository.logTransfer(request, operationId, success);

        return operationId;
    }

    public String confirmOperation(ConfirmOperationRequest request) {
        // Логика подтверждения операции (например, проверка кода подтверждения)
        System.out.println("Confirm operation " + request.getOperationId() + " with code " + request.getCode());
        return request.getOperationId();
    }

    private String generateOperationId() {
        return "OP" + System.currentTimeMillis();
    }
}
