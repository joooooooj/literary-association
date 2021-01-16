package com.la.dto;

import com.la.model.Status;

import java.time.LocalDateTime;

public class BankResponseDTO {

    private Long merchantOrderId;

    private String acqOrderId; // **** promenio zbog pay pala ****

    private LocalDateTime acqTimestamp;

    private Long paymentId;

    private Status status;

    public BankResponseDTO() {
    }

    public BankResponseDTO(Long merchantOrderId, String acqOrderId, LocalDateTime acqTimestamp, Long paymentId, Status status) {
        this.merchantOrderId = merchantOrderId;
        this.acqOrderId = acqOrderId;
        this.acqTimestamp = acqTimestamp;
        this.paymentId = paymentId;
        this.status = status;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getAcqOrderId() {
        return acqOrderId;
    }

    public void setAcqOrderId(String acqOrderId) {
        this.acqOrderId = acqOrderId;
    }

    public LocalDateTime getAcqTimestamp() {
        return acqTimestamp;
    }

    public void setAcqTimestamp(LocalDateTime acqTimestamp) {
        this.acqTimestamp = acqTimestamp;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankResponseDTO{" +
                "merchantOrderId=" + merchantOrderId +
                ", acqOrderId=" + acqOrderId +
                ", acqTimestamp=" + acqTimestamp +
                ", paymentId=" + paymentId +
                ", status=" + status +
                '}';
    }
}
