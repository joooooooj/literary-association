package com.la.model.dtos;

import com.la.model.enums.Status;

import java.time.LocalDateTime;

public class PCCResponseDTO {

    private Long acquirerOrderId;

    private LocalDateTime acquirerTimestamp;

    private Long issuerOrderId;

    private LocalDateTime issuerTimestamp;

    private Status status;

    public PCCResponseDTO() {
    }

    public PCCResponseDTO(Long acquirerOrderId, LocalDateTime acquirerTimestamp, Long issuerOrderId, LocalDateTime issuerTimestamp, Status status) {
        this.acquirerOrderId = acquirerOrderId;
        this.acquirerTimestamp = acquirerTimestamp;
        this.issuerOrderId = issuerOrderId;
        this.issuerTimestamp = issuerTimestamp;
        this.status = status;
    }

    public Long getAcquirerOrderId() {
        return acquirerOrderId;
    }

    public void setAcquirerOrderId(Long acquirerOrderId) {
        this.acquirerOrderId = acquirerOrderId;
    }

    public LocalDateTime getAcquirerTimestamp() {
        return acquirerTimestamp;
    }

    public void setAcquirerTimestamp(LocalDateTime acquirerTimestamp) {
        this.acquirerTimestamp = acquirerTimestamp;
    }

    public Long getIssuerOrderId() {
        return issuerOrderId;
    }

    public void setIssuerOrderId(Long issuerOrderId) {
        this.issuerOrderId = issuerOrderId;
    }

    public LocalDateTime getIssuerTimestamp() {
        return issuerTimestamp;
    }

    public void setIssuerTimestamp(LocalDateTime issuerTimestamp) {
        this.issuerTimestamp = issuerTimestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PCCResponseDTO{" +
                " acqOrderId=" + acquirerOrderId +
                ", acqTimestamp = " + acquirerTimestamp +
                ", issuerOrderId = " + issuerOrderId +
                ", issuerTimestamp = " + issuerTimestamp +
                ", status=" + status +
                '}';
    }
}
