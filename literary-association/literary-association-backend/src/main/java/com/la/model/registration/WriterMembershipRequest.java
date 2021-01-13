package com.la.model.registration;

import com.la.model.enums.WriterMembershipStatus;
import com.la.model.users.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("WRITER_MEMBERSHIP_REQUEST")
public class WriterMembershipRequest extends User {

    @Column
    private WriterMembershipStatus status;

    @Column
    private boolean activated;

    @Column
    private Date paymentDeadline;

    @Column
    private Integer attemptsNumber;

    @Column
    private Date submissionDeadline;
}