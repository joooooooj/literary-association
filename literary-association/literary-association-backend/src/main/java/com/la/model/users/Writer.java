package com.la.model.users;

import com.la.model.Membership;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("WRITER")
public class Writer extends User {

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;
}
