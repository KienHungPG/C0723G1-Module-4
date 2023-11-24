package com.example.validate_song.repository;

import com.example.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findAllByFlagDeleteIsFalse(Pageable pageable);

    Song findSongById(Integer id);
}
