package com.la.dto;

public class BankPaymentUrlDTO {

    private Long paymentId;

    private String paymentUrl;

    public BankPaymentUrlDTO() {
    }

    public BankPaymentUrlDTO(Long paymentId, String paymentUrl) {
        this.paymentId = paymentId;
        this.paymentUrl = paymentUrl;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    @Override
    public String toString() {
        return "BankPaymentUrlDTO{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentUrl='" + paymentUrl + '\'' +
                '}';
    }
}
