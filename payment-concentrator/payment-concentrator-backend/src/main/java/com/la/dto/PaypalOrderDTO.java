package com.la.dto;

import java.time.LocalDateTime;

public class PaypalOrderDTO {
    private Long userId;
    private Long merchantOrderId;
    private String merchantTimestamp;
    private Double amount;

    public PaypalOrderDTO() {
    }

    public PaypalOrderDTO(Long merchantId, String merchantTimestamp, Double amount, Long userId) {
        this.merchantOrderId = merchantId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }
}
