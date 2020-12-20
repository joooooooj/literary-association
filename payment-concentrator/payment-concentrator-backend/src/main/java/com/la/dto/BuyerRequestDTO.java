package com.la.dto;

import java.time.LocalDateTime;

public class BuyerRequestDTO {

    private Long subscriberId; // Id at payment concetrator

    private Long merchantId; // Id at bank database

    private Long merchantOrderId; // Order Id from LA

    private LocalDateTime merchantTimestamp;

    private float amount;

    public BuyerRequestDTO() {
    }

    public BuyerRequestDTO(Long subscriberId, Long merchantId, Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
        this.subscriberId = subscriberId;
        this.merchantId = merchantId;
        this.merchantOrderId = merchantOrderId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public LocalDateTime getMerchantTimestamp() {
        return merchantTimestamp;
    }

    public void setMerchantTimestamp(LocalDateTime merchantTimestamp) {
        this.merchantTimestamp = merchantTimestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BuyerRequestDTO{" +
                "merchantId=" + merchantId +
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", amount=" + amount +
                '}';
    }
}
