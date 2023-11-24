package com.example.validate_song.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "text", nullable = false)
    private String name;
    @Column(columnDefinition = "text", nullable = false)
    private String singer;
    @Column(columnDefinition = "text", nullable = false)
    private String type;
    private boolean flagDelete;

    public Song() {
    }

    public Song(Integer id, String name, String singer, String type, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.flagDelete = flagDelete;
    }

    public Song(String name, String singer, String type, boolean flagDelete) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.flagDelete = flagDelete;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
