package com.la.dto.paypal;

public class PaypalCreateOrderDTO {
    private Long orderId;
    private String redirectUrl;

    public PaypalCreateOrderDTO() {
    }

    public PaypalCreateOrderDTO(Long orderId, String redirectUrl) {
        this.orderId = orderId;
        this.redirectUrl = redirectUrl;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
