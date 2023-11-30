package com.codegym.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "Datetime")
    private LocalDateTime date;
    @Column(columnDefinition = "text")
    private String content;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_category")
    private Category category;
}
