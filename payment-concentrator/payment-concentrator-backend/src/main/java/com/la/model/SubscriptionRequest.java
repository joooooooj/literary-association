package com.la.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubscriptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String organizationName;

    @Column
    @NotNull
    private String organizationDescription;

    @Column
    @NotNull
    private String organizationEmail;

    @ManyToMany()
    @JoinTable(name = "subscription_requests_payment_methods",
            joinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id", referencedColumnName = "id"))
    private Set<PaymentMethod> paymentMethods;

    public Long getId() {
        return id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public String getOrganizationEmail() {
        return organizationEmail;
    }
}
