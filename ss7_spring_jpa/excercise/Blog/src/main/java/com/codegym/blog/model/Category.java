package com.codegym.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "topics", unique = true, nullable = false, columnDefinition = "LongText")
    private String topic;
    @OneToMany(mappedBy = "category")
    private List<Blog> blogList;

    private boolean flagDelete;

    public Category() {
    }

    public Category(Integer id, String topic, List<Blog> blogList, boolean flagDelete) {
        this.id = id;
        this.topic = topic;
        this.blogList = blogList;
        this.flagDelete = flagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
