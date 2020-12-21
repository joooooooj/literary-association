package com.la.dto;

import java.time.LocalDateTime;

public class BuyerRequestDTO {

    private Long merchantId;

    private Long merchantOrderId;

    private LocalDateTime merchantTimestamp;

    private float amount;

    public BuyerRequestDTO() {
    }

    public BuyerRequestDTO(Long merchantId, Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
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
