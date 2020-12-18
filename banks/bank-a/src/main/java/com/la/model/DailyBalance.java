package com.la.model;

import java.time.LocalDateTime;

public class DailyBalance {
    private Long id;

    private LocalDateTime dateTime;

    private float previous;

    private float current;

    private Account account;

    public DailyBalance() {
    }

    public DailyBalance(LocalDateTime dateTime, float previous, float current, Account account) {
        this.dateTime = dateTime;
        this.previous = previous;
        this.current = current;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getPrevious() {
        return previous;
    }

    public void setPrevious(float previous) {
        this.previous = previous;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
