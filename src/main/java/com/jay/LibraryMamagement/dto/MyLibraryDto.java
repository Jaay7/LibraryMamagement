package com.jay.LibraryMamagement.dto;

import java.util.Date;

public class MyLibraryDto {

    private Integer user_id;
    private Integer book_id;
    private Date dateStarted;
    private int pagesCompleted;
    private double progress;
    private String status;
    private Date dateFinished;

    public MyLibraryDto() {

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
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
