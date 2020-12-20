package com.la.model;

import javax.persistence.*;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String merchantId;

    @Column
    private String merchantPassword;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    public Merchant() {
    }

    public Merchant(Long id, String merchantId, String merchantPassword, Account account) {
        this.id = id;
        this.merchantId = merchantId;
        this.merchantPassword = merchantPassword;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
