package com.la.model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private float balance;

    @OneToOne
    private Merchant merchant;

    public Account() {
    }

    public Account(String accountNumber, Client client, float balance, Merchant merchant) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.merchant = merchant;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
