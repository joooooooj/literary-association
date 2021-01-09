package com.la.dto;

public class PaypalCreateOrderDTO {
    private String orderId;
    private String redirectUrl;

    public PaypalCreateOrderDTO() {
    }

    public PaypalCreateOrderDTO(String orderId, String redirectUrl) {
        this.orderId = orderId;
        this.redirectUrl = redirectUrl;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
