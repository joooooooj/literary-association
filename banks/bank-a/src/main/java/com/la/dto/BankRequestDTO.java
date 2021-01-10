package com.la.dto;

import java.time.LocalDateTime;

public class BankRequestDTO{

    private Long merchantId;

    private String merchantPassword;

    private Long merchantOrderId; // Order Id from LA

    private LocalDateTime merchantTimestamp;

    private float amount;

    public BankRequestDTO() {
    }

    public BankRequestDTO(Long merchantId, String merchantPassword, Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
        this.merchantId = merchantId;
        this.merchantPassword = merchantPassword;
        this.merchantOrderId = merchantOrderId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
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
        return "BankRequestDTO{" +
                "merchantId=" + merchantId +
                ", merchantPassword='" + merchantPassword + '\'' +
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", amount=" + amount +
                '}';
    }
}
