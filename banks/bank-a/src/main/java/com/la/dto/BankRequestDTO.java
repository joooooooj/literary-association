package com.la.dto;

public class BankRequestDTO {

    private String merchantPassword;

    private BuyerRequestDTO buyerRequestDTO;

    public BankRequestDTO() {
    }

    public BankRequestDTO(String merchantPassword, BuyerRequestDTO buyerRequestDTO) {
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

    @Override
    public String toString() {
        return "BankRequestDTO{" +
                "merchantPassword='" + merchantPassword + '\'' +
                ", buyerRequestDTO=" + buyerRequestDTO +
                '}';
    }
}
