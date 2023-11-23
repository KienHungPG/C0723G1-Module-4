package com.example.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String introduce;

    private String image;

    private String title;

    @Column(columnDefinition = "LongText")
    private String content;

    @Column(name = "date_writing")
    private LocalDateTime dateWriting;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog() {
        this.status = false;
    }


    public Blog(Integer id, String introduce, String image, String title, String content, LocalDateTime dateWriting, Category category) {
        this.id = id;
        this.introduce = introduce;
        this.image = image;
        this.title = title;
        this.content = content;
        this.dateWriting = dateWriting;
        this.status = false;
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
