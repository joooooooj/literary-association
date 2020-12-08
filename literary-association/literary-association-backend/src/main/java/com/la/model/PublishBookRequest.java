package com.la.model;

import javax.persistence.*;

@Entity
public class PublishBookRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public PublishBookRequest() {
    }

    public PublishBookRequest(String title, String synopsis, Editor editor, Writer writer, Genre genre) {
        this.title = title;
        this.synopsis = synopsis;
        this.editor = editor;
        this.writer = writer;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
