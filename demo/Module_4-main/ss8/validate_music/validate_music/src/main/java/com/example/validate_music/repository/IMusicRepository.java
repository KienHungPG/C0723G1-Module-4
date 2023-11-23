package com.example.validate_music.repository;

import com.example.validate_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Page<Music> findAllByFlagDeleteIsFalse(Pageable pageable);
}
