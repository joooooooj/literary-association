package com.la.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_id", nullable = false)
    private Long paymentId; // Payment ID from merchant bank

    @Column(name = "acq_order_id", nullable = false)
    private Long acqOrderId; // Order ID from merchant bank

    @Column(name = "acq_timestamp", nullable = false)
    private LocalDateTime acqTimestamp; // Order Timestamp from merchant bank

    @Column(name = "merchant_order_id", nullable = false)
    private Long merchantOrderId; // Order ID from merchant database (literary-assocation)

    @Column(name = "merchant_timestamp", nullable = false)
    private LocalDateTime merchantTimestamp; // Timestamp from merchant database (literary-assocation)

    @Column(name = "status", nullable = false)
    private Status status; // PENDING, SUCCESS, FAILED, ERROR

    @OneToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    public Transaction() {
    }

    public Transaction(Long id, Long paymentId, Long acqOrderId, LocalDateTime acqTimestamp, Long merchantOrderId, LocalDateTime merchantTimestamp, Status status, PaymentMethod paymentMethod) {
        this.id = id;
        this.paymentId = paymentId;
        this.acqOrderId = acqOrderId;
        this.acqTimestamp = acqTimestamp;
        this.merchantOrderId = merchantOrderId;
        this.merchantTimestamp = merchantTimestamp;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getAcqOrderId() {
        return acqOrderId;
    }

    public void setAcqOrderId(Long acqOrderId) {
        this.acqOrderId = acqOrderId;
    }

    public LocalDateTime getAcqTimestamp() {
        return acqTimestamp;
    }

    public void setAcqTimestamp(LocalDateTime acqTimestamp) {
        this.acqTimestamp = acqTimestamp;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", paymentId=" + paymentId +
                ", acqOrderId=" + acqOrderId +
                ", acqTimestamp=" + acqTimestamp +
                ", merchantOrderId=" + merchantOrderId +
                ", merchantTimestamp=" + merchantTimestamp +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
