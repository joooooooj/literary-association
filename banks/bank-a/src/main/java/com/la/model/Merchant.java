package com.la.model;

import javax.persistence.*;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column
    private String companyName;

    @Column
    private String address;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    public Merchant() {
    }

    public Merchant(Long id, String password, String companyName, String address, Account account) {
        this.id = id;
        this.password = password;
        this.companyName = companyName;
        this.address = address;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", account=" + account +
                '}';
    }
}
