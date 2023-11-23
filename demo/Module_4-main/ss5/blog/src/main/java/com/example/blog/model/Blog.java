package com.example.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 1000)
    private String introduce;
    @Column(length = 1000)
    private String image;
    @Column(length = 1000)
    private String title;
    @Column(length = 1000)
    private String content;

    private LocalDateTime dateWriting;

    public Blog() {
    }


    public Blog(Integer id, String name, String image, String title, String content, LocalDateTime dateWriting) {
        this.id = id;
        this.introduce = name;
        this.image = image;
        this.title = title;
        this.content = content;
        this.dateWriting = dateWriting;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public LocalDateTime getDateWriting() {
        return dateWriting;
    }

    public void setDateWriting(LocalDateTime dateWriting) {
        this.dateWriting = dateWriting;
    }
}
