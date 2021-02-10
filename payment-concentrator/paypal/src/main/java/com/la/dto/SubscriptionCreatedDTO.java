package com.la.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionCreatedDTO {
    private String clientId;
    private String planId;
    private String redirectUrl;
}
