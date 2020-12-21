package com.la.dto;

import com.la.model.Status;

public class SubscriberUpdateTransactionDTO {

    private Long merchantOrderId;

    private Status status;

    public SubscriberUpdateTransactionDTO() {
    }

    public SubscriberUpdateTransactionDTO(Long merchantOrderId, Status status) {
        this.merchantOrderId = merchantOrderId;
        this.status = status;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubscriberUpdateTransaction{" +
                "merchantOrderId=" + merchantOrderId +
                ", status=" + status +
                '}';
    }
}
