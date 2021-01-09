package com.la.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_id")
    private Long paymentId; // Payment ID from merchant bank

    @Column(name = "acq_order_id", nullable = false)
    private String acqOrderId; // Order ID from merchant bank

    @Column(name = "acq_timestamp")
    private LocalDateTime acqTimestamp; // Order Timestamp from merchant bank

    @OneToOne
    @JoinColumn(name = "buyer_request_id", referencedColumnName = "id")
    private BuyerRequest buyerRequest;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status; // WAITING, SUCCESS, FAILED, ERROR

    @OneToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    public Transaction() {
    }

    public Transaction(Long id, Long paymentId, String acqOrderId, LocalDateTime acqTimestamp, Long merchantOrderId, LocalDateTime merchantTimestamp, Status status, PaymentMethod paymentMethod) {
        this.id = id;
        this.paymentId = paymentId;
        this.acqOrderId = acqOrderId;
        this.acqTimestamp = acqTimestamp;
        this.buyerRequest = buyerRequest;
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

    public String getAcqOrderId() {
        return acqOrderId;
    }

    public void setAcqOrderId(String acqOrderId) {
        this.acqOrderId = acqOrderId;
    }

    public LocalDateTime getAcqTimestamp() {
        return acqTimestamp;
    }

    public void setAcqTimestamp(LocalDateTime acqTimestamp) {
        this.acqTimestamp = acqTimestamp;
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

    public BuyerRequest getBuyerRequest() {
        return buyerRequest;
    }

    public void setBuyerRequest(BuyerRequest buyerRequest) {
        this.buyerRequest = buyerRequest;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", paymentId=" + paymentId +
                ", acqOrderId=" + acqOrderId +
                ", acqTimestamp=" + acqTimestamp +
                ", buyerRequest=" + buyerRequest +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
