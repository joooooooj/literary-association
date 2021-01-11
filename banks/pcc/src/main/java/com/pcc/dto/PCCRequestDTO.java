package com.pcc.dto;

import java.time.LocalDateTime;

public class PCCRequestDTO {

    private String pan;

    private String securityCode;

    private String expireDate;

    private String cardholderName;

    private Long acquirerOrderId;

    private LocalDateTime acquirerTimestamp;

    public PCCRequestDTO() {
    }

    public PCCRequestDTO(String pan, String securityCode, String expireDate, String cardholderName, Long acquirerOrderId, LocalDateTime acquirerTimestamp) {
        this.pan = pan;
        this.securityCode = securityCode;
        this.expireDate = expireDate;
        this.cardholderName = cardholderName;
        this.acquirerOrderId = acquirerOrderId;
        this.acquirerTimestamp = acquirerTimestamp;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
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
}
