package com.la.model;

import javax.persistence.*;

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

    public SubscriberDetails() {
    }

    public SubscriberDetails(Long id, Long merchantId, String merchantPassword, String successUrl, String failedUrl, String errorUrl) {
        this.id = id;
        this.merchantId = merchantId;
        this.merchantPassword = merchantPassword;
        this.successUrl = successUrl;
        this.failedUrl = failedUrl;
        this.errorUrl = errorUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailedUrl() {
        return failedUrl;
    }

    public void setFailedUrl(String failedUrl) {
        this.failedUrl = failedUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    @Override
    public String toString() {
        return "SubscriberDetails{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", merchantPassword='" + merchantPassword + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", failedUrl='" + failedUrl + '\'' +
                ", errorUrl='" + errorUrl + '\'' +
                '}';
    }
}
