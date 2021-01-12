package com.la.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatedBookPurchaseRequestDTO {
    private Long orderId;
    private String timestamp;
    private Double amount;
    private String token;
    private String username;

    public CreatedBookPurchaseRequestDTO(Long orderId, String timestamp, Double amount, String token, String username) {
        this.orderId = orderId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.token = token;
        this.username = username;
    }
}
