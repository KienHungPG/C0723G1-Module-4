package com.codegym.demo_thymeleaf.model;

import javax.persistence.*;


@Entity
//@Table(name = "sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "ten", columnDefinition = "TEXT")
    private String name;
    private int gender;

    public Student() {
    }

    public Student(int id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
