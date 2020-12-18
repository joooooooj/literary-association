package com.la.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //payment_id

    @OneToOne
    private Merchant merchant;

    @Column
    private Long issuerId;

    @Column
    private Long merchantOrderId;

    @Column
    private LocalDateTime timestamp;

    @Column
    private float amount;

    @Column
    private boolean success;

    public Transaction(Merchant merchant, Long issuerId, Long merchantOrderId, LocalDateTime timestamp, float amount, boolean success) {
        this.merchant = merchant;
        this.issuerId = issuerId;
        this.merchantOrderId = merchantOrderId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.success = success;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
