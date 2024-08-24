package com.example.transferservice.model;

import lombok.Data;

    @Data
    public class TransferRequest{
        private String cardFromNumber;
        private String cardFromValidTill;
        private String cardFromCVV;
        private String cardToNumber;
        private Amount amount;

        @Data
        public static class Amount {
            private int value;
            private String currency;
        }
    }
