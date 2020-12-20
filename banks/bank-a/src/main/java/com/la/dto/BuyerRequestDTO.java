package com.la.dto;

import java.time.LocalDateTime;

public class BuyerRequestDTO {

    private Long subscriberId; // Id at payment concetrator

    private Long merchantOrderId; // Order Id from LA

    private LocalDateTime merchantTimestamp;

    private float amount;

    public BuyerRequestDTO() {
    }

    public BuyerRequestDTO(Long subscriberId, Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
        this.subscriberId = subscriberId;
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

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public String toString() {
        return "BuyerRequestDTO{" +
                "subscriberId=" + subscriberId +
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", amount=" + amount +
                '}';
    }
}
