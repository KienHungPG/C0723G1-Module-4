package com.example.validate_music.service;

import com.example.validate_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> getList(Pageable pageable);

    void create(Music music);

    void update(Music music);

    Music findById(int id);

    void deleteById(int id);
}
