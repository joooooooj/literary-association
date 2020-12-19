package com.la.model;

import com.la.model.enumeration.Opinion;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BoardMemberComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private Date date;

    @Column
    private Opinion opinion;

    @ManyToOne
    @JoinColumn(name = "submitted_work_id")
    private SubmittedWork submittedWork;

    @ManyToOne
    @JoinColumn(name = "board_member_id")
    private BoardMember boardMember;

    public BoardMemberComment() {
    }

    public BoardMemberComment(String text, Date date, Opinion opinion, SubmittedWork submittedWork, BoardMember boardMember) {
        this.text = text;
        this.date = date;
        this.opinion = opinion;
        this.submittedWork = submittedWork;
        this.boardMember = boardMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(Opinion opinion) {
        this.opinion = opinion;
    }

    public SubmittedWork getSubmittedWork() {
        return submittedWork;
    }

    public void setSubmittedWork(SubmittedWork submittedWork) {
        this.submittedWork = submittedWork;
    }

    public BoardMember getBoardMember() {
        return boardMember;
    }

    public void setBoardMember(BoardMember boardMember) {
        this.boardMember = boardMember;
    }
}
