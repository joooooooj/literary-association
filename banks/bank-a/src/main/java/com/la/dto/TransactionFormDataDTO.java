package com.la.dto;

public class TransactionFormDataDTO {

    private String pan;

    private String securityCode;

    private String cardholderName;

    private String expireDate;

    public TransactionFormDataDTO() {
    }

    public TransactionFormDataDTO(String pan, String securityCode, String cardholderName, String expireDate) {
        this.pan = pan;
        this.securityCode = securityCode;
        this.cardholderName = cardholderName;
        this.expireDate = expireDate;
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

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "TransactionFormDataDTO{" +
                "pan='" + pan + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
