package com.codegym.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @Column(columnDefinition = "LongText")
    private String description;

    @Column(columnDefinition = "LongText")
    private String content;

    private LocalDateTime createTime;
    private String image;

    @Column(columnDefinition = "bit")
    private boolean flagDelete;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, String description, String content, LocalDateTime createTime, String image, boolean flagDelete, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createTime = createTime;
        this.image = image;
        this.flagDelete = flagDelete;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
