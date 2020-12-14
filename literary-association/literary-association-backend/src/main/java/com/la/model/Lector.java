package com.la.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LECTOR")
public class Lector extends User{

    public Lector() {
    }

    public Lector(String username, String password, String firstName, String lastName, String state, String city, String email) {
        super(username, password, firstName, lastName, state, city, email);
    }
}
