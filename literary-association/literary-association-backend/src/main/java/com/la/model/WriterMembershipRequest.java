package com.la.model;

import com.la.model.enumeration.WriterMembershipStatus;

import javax.persistence.*;
import java.util.Date;

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

    public WriterMembershipRequest() {
    }

    public WriterMembershipRequest(String username, String password, String firstName, String lastName, String state, String city, String email) {
        super(username, password, firstName, lastName, state, city, email);
    }

    public WriterMembershipStatus getStatus() {
        return status;
    }

    public void setStatus(WriterMembershipStatus status) {
        this.status = status;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Integer getAttemptsNumber() {
        return attemptsNumber;
    }

    public void setAttemptsNumber(Integer attemptsNumber) {
        this.attemptsNumber = attemptsNumber;
    }

    public Date getSubmissionDeadline() {
        return submissionDeadline;
    }

    public void setSubmissionDeadline(Date submissionDeadline) {
        this.submissionDeadline = submissionDeadline;
    }
}
