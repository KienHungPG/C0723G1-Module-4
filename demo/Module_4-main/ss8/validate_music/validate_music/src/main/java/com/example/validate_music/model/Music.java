package com.example.validate_music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String artist;
    private String type;

    private boolean flagDelete;

    public Music() {
        flagDelete = false;
    }

    public Music(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        flagDelete = false;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}