package com.la.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_id")
    private Long paymentId; // Payment ID from merchant bank

    @Column(name = "acq_order_id", nullable = false)
    private String acqOrderId; // Order ID from merchant bank **** promenio na string zbog pay pala ****

    @Column(name = "acq_timestamp")
    private LocalDateTime acqTimestamp; // Order Timestamp from merchant bank

    @Column(name = "timestamp")
    private LocalDateTime timestamp; // Order Timestamp from merchant bank

    @OneToOne
    @JoinColumn(name = "buyer_request_id", referencedColumnName = "id")
    private BuyerRequest buyerRequest;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status; // WAITING, SUCCESS, FAILED, ERROR

    @OneToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

}
