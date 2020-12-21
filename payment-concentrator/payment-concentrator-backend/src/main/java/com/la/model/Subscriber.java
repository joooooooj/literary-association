package com.la.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("SUBSCRIBER")
public class Subscriber extends User {

    @OneToMany
    @JoinColumn(name = "subscriber_id", unique = true)
    private List<Transaction> transactions;

    @OneToOne()
    @JoinColumn(name = "subscriber_details_id", referencedColumnName = "id")
    private SubscriberDetails subscriberDetails;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "subscriber_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id", referencedColumnName = "id"))
    private Set<PaymentMethod> paymentMethods;

    public Subscriber() {
    }

    public Subscriber(String username, String password, String email, Set<PaymentMethod> methods) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.paymentMethods = methods;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public SubscriberDetails getSubscriberDetails() {
        return subscriberDetails;
    }

    public void setSubscriberDetails(SubscriberDetails subscriberDetails) {
        this.subscriberDetails = subscriberDetails;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "transactions=" + transactions +
                ", subscriberDetails=" + subscriberDetails +
                ", paymentMethods=" + paymentMethods +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
