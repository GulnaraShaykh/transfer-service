package com.example.transferservice.model;


import lombok.Data;

@Data public class ConfirmOperationRequest {
    private String operationId;
    private String code;
}
