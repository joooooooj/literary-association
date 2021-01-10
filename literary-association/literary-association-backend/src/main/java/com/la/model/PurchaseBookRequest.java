package com.la.model;

import com.la.enumeration.TransactionStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class PurchaseBookRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column
    private Double price;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "purchase_book",
            joinColumns = @JoinColumn(name = "purchase_book_request_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<Book> bookList;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public PurchaseBookRequest() {
    }

    public PurchaseBookRequest(TransactionStatus status, Double price, List<Book> bookList, Reader reader) {
        this.status = status;
        this.price = price;
        this.bookList = bookList;
        this.reader = reader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
