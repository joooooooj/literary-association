package com.la.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOARD_MEMBER")
public class BoardMember extends User{

    public BoardMember() {
    }

    public BoardMember(String username, String password, String firstName, String lastName, String state, String city, String email) {
        super(username, password, firstName, lastName, state, city, email);
    }
}
