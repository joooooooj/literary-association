package com.la.model;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String pan;

    @Column
    private String securityCode;

    @Column
    private String expireDate;

    @Column
    private String cardholderName;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Card() {
    }

    public Card(Long id, String pan, String securityCode, String expireDate, String cardholderName, Account account) {
        this.id = id;
        this.pan = pan;
        this.securityCode = securityCode;
        this.expireDate = expireDate;
        this.cardholderName = cardholderName;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", pan='" + pan + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", account=" + account +
                '}';
    }
}