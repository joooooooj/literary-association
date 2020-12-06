package com.la.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("SUB")
public class Subscriber extends User {

    public Subscriber() {
    }

    public Subscriber(String username, String password, String email, Set<PaymentMethod> methods) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.paymentMethods = methods;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "subscriber_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id", referencedColumnName = "id"))
    private Set<PaymentMethod> paymentMethods;
}
