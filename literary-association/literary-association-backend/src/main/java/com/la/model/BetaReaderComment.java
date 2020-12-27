package com.la.model;

import com.la.model.users.Reader;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BetaReaderComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date deadline;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "script_request_id")
    private ScriptRequest scriptRequest;

    public BetaReaderComment() {
    }

    public BetaReaderComment(Date deadline, String text, Reader reader, ScriptRequest scriptRequest) {
        this.deadline = deadline;
        this.text = text;
        this.reader = reader;
        this.scriptRequest = scriptRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ScriptRequest getScriptRequest() {
        return scriptRequest;
    }

    public void setScriptRequest(ScriptRequest scriptRequest) {
        this.scriptRequest = scriptRequest;
    }
}
