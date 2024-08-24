
package com.example.transferservice.repository;

import com.example.transferservice.model.TransferRequest;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Repository
public class TransferRepository {

    private static final String LOG_FILE_PATH = "transfer-log.txt";

    public void logTransfer(TransferRequest request, String operationId, boolean success) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            out.println("DateTime: " + LocalDateTime.now());
            out.println("From: " + request.getCardFromNumber());
            out.println("To: " + request.getCardToNumber());
            out.println("Amount: " + request.getAmount().getValue() + " " + request.getAmount().getCurrency());
            out.println("Operation ID: " + operationId);
            out.println("Status: " + (success ? "SUCCESS" : "FAILURE"));
            out.println("--------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

