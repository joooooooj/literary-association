package com.la.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("SUBSCRIBER")
public class Subscriber extends User {

    @Column
    private String clientId;

    @Column
    private String clientSecret;

    @OneToOne()
    @JoinColumn(name = "subscriber_details_id", referencedColumnName = "id")
    private SubscriberDetails subscriberDetails;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "subscriber_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id", referencedColumnName = "id"))
    private Set<PaymentMethod> paymentMethods;

    public Subscriber(String username, String password, String email, Set<PaymentMethod> methods, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.paymentMethods = methods;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}
