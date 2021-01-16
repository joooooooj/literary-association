package com.la.model.dtos.paypal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaypalCreateOrderDTO {

    private Long orderId;
    private String redirectUrl;
}
