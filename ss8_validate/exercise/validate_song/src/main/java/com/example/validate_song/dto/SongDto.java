package com.example.validate_song.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    private Integer id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String name;
    @NotBlank(message = "Tên ca sĩ không được để trống")
    @Size(max = 300, message = "Tên ca sĩ không được quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên ca sĩ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String singer;
    @NotBlank(message = "Tên thể loại không được để trống")
    @Size(max = 1000, message = "Tên thể loại không được quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$", message = "Thể loại không chứa các kí tự đặc biệt như @;.=-+,.... Nhưng cho phép dấu ','")
    private String type;
    private boolean flagDelete;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String singer, String type, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.flagDelete = flagDelete;
    }

    public SongDto(String name, String singer, String type, boolean flagDelete) {
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
