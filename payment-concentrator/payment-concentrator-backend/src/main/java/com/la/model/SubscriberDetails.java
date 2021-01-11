package com.la.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SubscriberDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_id", nullable = false)
    private Long merchantId;

    @Column(name = "merchant_password", nullable = false)
    private String merchantPassword;

    @Column(name = "merchant_success_url", nullable = false)
    private String successUrl;

    @Column(name = "merchant_failed_url", nullable = false)
    private String failedUrl;

    @Column(name = "merchant_error_url", nullable = false)
    private String errorUrl;
}
