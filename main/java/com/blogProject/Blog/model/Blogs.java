package com.blogProject.Blog.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Blogs {
    @Id
    @GeneratedValue
    private int BlogId;
    private Date date;
    private String title;
    private String author;
    private String content;
    private Boolean Private = false;
    @ManyToOne
    private Users userId;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBlogId() {
        return BlogId;
    }

    public void setBlogId(int blogId) {
        BlogId = blogId;
    }

    public Boolean getPrivate() {
        return Private;
    }

    public void setPrivate(Boolean aPrivate) {
        Private = aPrivate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUserId() { return userId; }

    public void setUserId(Users userId) { this.userId = userId; }
}
