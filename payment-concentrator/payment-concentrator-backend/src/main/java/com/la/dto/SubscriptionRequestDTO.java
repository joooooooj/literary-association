package com.la.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class SubscriptionRequestDTO {
    private Long id;

    @NotEmpty
    private String organizationName;

    @NotEmpty
    private String organizationDescription;

    @NotEmpty
    private String organizationEmail;

    @NotEmpty
    private Set<PaymentMethodDTO> paymentMethods;
}
