package com.la.model.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreatedBookPurchaseRequestDTO {
    private Long orderId;
    private LocalDateTime timestamp;
    private Double amount;
    private String token;
    private String username;
}
