package com.example.validate_music.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class MusicDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Không được để khoảng trắng")
    @Size(max = 800, message = "Không được vượt quá 800 từ")
    @Pattern(regexp = "^[\\w ]+", message = "Không bao gồm ký tự đặc biệt")
    private String name;

    @NotBlank(message = "Không được để khoảng trắng")
    @Size(max = 300, message = "Không được vượt quá 300 từ")
    @Pattern(regexp = "^[\\w ]+", message = "Không bao gồm ký tự đặc biệt")
    private String artist;
    @NotBlank(message = "Không được để khoảng trắng")
    @Size(max = 1000, message = "Không được vượt quá 1000 từ")
    @Pattern(regexp = "^[\\w, ]+", message = "Không bao gồm ký tự đặc biệt ngoại trừ ','")
    private String type;

    private boolean flagDelete;

    public MusicDto() {
        flagDelete = false;
    }

    public MusicDto(int id, String name, String artist, String type) {
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
