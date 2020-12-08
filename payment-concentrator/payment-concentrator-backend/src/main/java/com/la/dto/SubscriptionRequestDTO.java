package com.la.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SubscriptionRequestDTO {
    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationEmail;
    private Set<PaymentMethodDTO> paymentMethods;
}
