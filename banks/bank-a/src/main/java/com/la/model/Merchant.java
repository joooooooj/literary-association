package com.la.model;

import javax.persistence.*;

@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String merchantId;

    @Column
    private String merchantPassword;

    public Merchant() {
    }

    public Merchant(String merchantId, String merchantPassword) {
        this.merchantId = merchantId;
        this.merchantPassword = merchantPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }
}
