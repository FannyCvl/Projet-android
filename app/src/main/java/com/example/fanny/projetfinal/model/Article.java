package com.example.fanny.projetfinal.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Article {

    private String id = "";
    private String name = "";
    private String author = "";
    private String title = "";
    private String description = "";
    private String url = "";
    private String urlToImage = "";
    private String publishedAt = "";

    public Article() {
        this.id = "";
        this.name = "";
        this.author = "";
        this.title = "";
        this.description = "";
        this.url = "";
        this.urlToImage = "";
        this.publishedAt = "";
    }

    public Article(String id, String name, String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
