package com.jay.LibraryMamagement.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "mylibrary")
public class MyLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Books book;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date dateStarted;

    @Column(nullable = false)
    private int pagesCompleted;

    @Column(nullable = false)
    private double progress;

    @Column(nullable = false)
    private String status;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = true)
    private Date dateFinished;

    public MyLibrary() {
    }

    public MyLibrary(Integer id, User user, Books book, Date dateStarted, int pagesCompleted, double progress,
            String status, Date dateFinished) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dateStarted = dateStarted;
        this.pagesCompleted = pagesCompleted;
        this.progress = progress;
        this.status = status;
        this.dateFinished = dateFinished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public int getPagesCompleted() {
        return pagesCompleted;
    }

    public void setPagesCompleted(int pagesCompleted) {
        this.pagesCompleted = pagesCompleted;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

}
