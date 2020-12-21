package com.la.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BuyerRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subscriber_id", referencedColumnName = "id")
    Subscriber subscriber;

    @Column
    private Long merchantOrderId; // Order Id from LA

    @Column
    private LocalDateTime merchantTimestamp;

    @Column
    private float amount;

    public BuyerRequest() {
    }

    public BuyerRequest(Long id, Subscriber subscriber, Long merchantOrderId, LocalDateTime merchantTimestamp, float amount) {
        this.id = id;
        this.subscriber = subscriber;
        this.merchantOrderId = merchantOrderId;
        this.merchantTimestamp = merchantTimestamp;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Long getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Long merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public LocalDateTime getMerchantTimestamp() {
        return merchantTimestamp;
    }

    public void setMerchantTimestamp(LocalDateTime merchantTimestamp) {
        this.merchantTimestamp = merchantTimestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", subscriber=" + subscriber +
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", amount=" + amount +
                '}';
    }
}
