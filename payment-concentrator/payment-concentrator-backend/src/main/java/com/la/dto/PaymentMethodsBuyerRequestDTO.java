package com.la.dto;

import com.la.model.PaymentMethod;

import java.util.Set;

public class PaymentMethodsBuyerRequestDTO {

    private String url;

    private String username;

    private BuyerRequestDTO buyerRequestDTO;

    private Set<PaymentMethod> paymentMethods;

    public PaymentMethodsBuyerRequestDTO() {
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BuyerRequestDTO getBuyerRequestDTO() {
        return buyerRequestDTO;
    }

    public void setBuyerRequestDTO(BuyerRequestDTO buyerRequestDTO) {
        this.buyerRequestDTO = buyerRequestDTO;
    }

    @Override
    public String toString() {
        return "PaymentMethodsBuyerRequestDTO{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", buyerRequestDTO=" + buyerRequestDTO +
                ", paymentMethods=" + paymentMethods +
                '}';
    }
}
