package com.la.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatedBookPurchaseRequestDTO {
    private Long orderId;
    private LocalDateTime timestamp;
    private Double amount;
    private String token;
    private String username;

    public CreatedBookPurchaseRequestDTO(Long orderId, LocalDateTime timestamp, Double amount, String token, String username) {
        this.orderId = orderId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.token = token;
        this.username = username;
    }
}
