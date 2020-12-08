package com.la.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("WRITER")
public class Writer extends User{

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

    public Writer(String username, String password, String firstName, String lastName, String state, String city, String email, Membership membership) {
        super(username, password, firstName, lastName, state, city, email);
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
}
