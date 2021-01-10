package com.la.dto;

import java.time.LocalDateTime;

public class BuyerRequestDTO {

    private Long merchantOrderId; // Order Id from LA

    private LocalDateTime merchantTimestamp;

    private float amount;

    public BuyerRequestDTO() {
    }

    public BuyerRequestDTO(Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
        this.merchantOrderId = merchantOrderId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
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
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", amount=" + amount +
                '}';
    }
}
