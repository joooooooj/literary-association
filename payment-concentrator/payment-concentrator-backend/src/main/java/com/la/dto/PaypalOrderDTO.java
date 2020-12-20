package com.la.dto;

import java.time.LocalDateTime;

public class PaypalOrderDTO {
    private Long merchantOrderId;
    private String merchantTimestamp;
    private Double amount;

    public PaypalOrderDTO() {
    }

    public PaypalOrderDTO(Long merchantId, String merchantTimestamp, Double amount) {
        this.merchantOrderId = merchantId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public String getMerchantTimestamp() {
        return merchantTimestamp;
    }

    public Double getAmount() {
        return amount;
    }
}
