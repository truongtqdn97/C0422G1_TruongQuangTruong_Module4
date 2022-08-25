package com.example.service.impl;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return this.iMusicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }
}
