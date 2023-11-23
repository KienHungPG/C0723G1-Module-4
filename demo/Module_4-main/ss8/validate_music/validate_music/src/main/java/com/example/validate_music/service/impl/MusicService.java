package com.example.validate_music.service.impl;

import com.example.validate_music.model.Music;
import com.example.validate_music.repository.IMusicRepository;
import com.example.validate_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> getList(Pageable pageable) {
        return musicRepository.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void create(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        Music music1 = findById(music.getId());
        music1.setName(music.getName());
        music1.setArtist(music.getArtist());
        music1.setType(music.getType());
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Music music = findById(id);
        music.setFlagDelete(true);
        musicRepository.save(music);
    }

}
