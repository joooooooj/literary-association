package com.la.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String pan;

    @Column
    private String securityCode;

    @Column
    private LocalDateTime expireDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Card() {
    }

    public Card(String pan, String securityCode, LocalDateTime expireDate, Account account) {
        this.pan = pan;
        this.securityCode = securityCode;
        this.expireDate = expireDate;
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

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
