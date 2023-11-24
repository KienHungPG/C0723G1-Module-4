package com.example.validate_song.service.impl;

import com.example.validate_song.model.Song;
import com.example.validate_song.repository.ISongRepository;
import com.example.validate_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getSongs(Pageable pageable) {
        return songRepository.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void create(Song song) {
        song.setFlagDelete(false);
        songRepository.save(song);
    }

    @Override
    public Song getById(Integer id) {
        return songRepository.findSongById(id);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Integer id) {
        Song song = songRepository.findSongById(id);
        song.setFlagDelete(true);
        this.update(song);
    }
}
