package com.la.model.users;

import com.la.model.Genre;
import com.la.model.Membership;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@DiscriminatorValue("READER")
public class Reader extends SysUser implements Serializable {

    @Column
    private boolean isBeta;

    @Column
    private Integer penaltyPoints;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "beta_reader_genre",
            joinColumns = @JoinColumn(name = "beta_reader_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> betaReaderGenres;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

    public Reader() {
    }

    public Reader(String username, String password, String firstName, String lastName, String state, String city, String email, boolean isBeta, Integer penaltyPoints) {
        super(username, password, firstName, lastName, state, city, email);
        this.isBeta = isBeta;
        this.penaltyPoints = penaltyPoints;
    }

    public boolean isBeta() {
        return isBeta;
    }

    public void setBeta(boolean beta) {
        isBeta = beta;
    }

    public Integer getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(Integer penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }


    public Set<Genre> getBetaReaderGenres() {
        return betaReaderGenres;
    }

    public void setBetaReaderGenres(Set<Genre> betaReaderGenres) {
        this.betaReaderGenres = betaReaderGenres;
    }
}

