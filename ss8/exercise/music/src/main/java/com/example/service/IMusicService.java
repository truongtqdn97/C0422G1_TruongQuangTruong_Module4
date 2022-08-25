package com.example.service;

import com.example.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);

    void save(Music music);
}
