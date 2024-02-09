package com.jay.LibraryMamagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int countofpages;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String coverPhoto;

    @Column(nullable = false)
    private String suitableAudience;

    @Column(nullable = false)
    private String firebaseFile;

    public Books() {
    }

    public Books(Integer id, String name, String description, double price, String author, String genre,
            int countofpages, Date releaseDate, String coverPhoto, String suitableAudience, String firebaseFile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.countofpages = countofpages;
        this.releaseDate = releaseDate;
        this.coverPhoto = coverPhoto;
        this.suitableAudience = suitableAudience;
        this.firebaseFile = firebaseFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCountofpages() {
        return countofpages;
    }

    public void setCountofpages(int countofpages) {
        this.countofpages = countofpages;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getSuitableAudience() {
        return suitableAudience;
    }

    public void setSuitableAudience(String suitableAudience) {
        this.suitableAudience = suitableAudience;
    }

    public String getFirebaseFile() {
        return firebaseFile;
    }

    public void setFirebaseFile(String firebaseFile) {
        this.firebaseFile = firebaseFile;
    }

}