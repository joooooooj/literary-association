package com.la.dto;

import java.time.LocalDateTime;

public class BankRequestDTO{

    private Long merchantId;

    private String merchantPassword;

    private BuyerRequestDTO buyerRequestDTO;

    public BankRequestDTO() {
    }

    public BankRequestDTO(Long merchantId, String merchantPassword, BuyerRequestDTO buyerRequestDTO) {
        this.merchantId = merchantId;
        this.merchantPassword = merchantPassword;
        this.buyerRequestDTO = buyerRequestDTO;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public BuyerRequestDTO getBuyerRequestDTO() {
        return buyerRequestDTO;
    }

    public void setBuyerRequestDTO(BuyerRequestDTO buyerRequestDTO) {
        this.buyerRequestDTO = buyerRequestDTO;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "BankRequestDTO{" +
                "merchantPassword='" + merchantPassword + '\'' +
                ", buyerRequestDTO=" + buyerRequestDTO +
                '}';
    }
}
