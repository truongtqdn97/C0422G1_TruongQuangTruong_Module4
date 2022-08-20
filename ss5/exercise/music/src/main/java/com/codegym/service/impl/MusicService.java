package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return this.iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        this.iMusicRepository.update(music);
    }

    @Override
    public void remove(int id) {
        this.iMusicRepository.remove(id);
    }
}
