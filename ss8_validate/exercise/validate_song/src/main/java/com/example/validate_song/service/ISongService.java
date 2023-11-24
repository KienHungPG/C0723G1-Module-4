package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> getSongs(Pageable pageable);

    void create(Song song);

    Song getById(Integer id);

    void update(Song song);

    void delete(Integer id);
}
