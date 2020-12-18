package com.la.model;

public class Payment {
    public String paymentId;
    public String paymentUrl;

    public Payment(String paymentId, String paymentUrl) {
        this.paymentId = paymentId;
        this.paymentUrl = paymentUrl;
    }

    public Payment() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }
}
