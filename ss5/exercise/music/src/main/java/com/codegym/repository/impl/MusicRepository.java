package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    private static final String SELECT_ALL_MUSIC = "select m from Music as m";
    private static final String SELECT_MUSIC = "select m from Music as m where m.id = :id";

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> musicTypedQuery = BaseRepository.entityManager.createQuery(SELECT_ALL_MUSIC, Music.class);
        return musicTypedQuery.getResultList();
        //lay ra List<> ket qua
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        BaseRepository.entityManager.persist(music);

        entityTransaction.commit();
        //phai co entity transaction thi moi them du lieu moi vao table trong db duoc
    }

    @Override
    public Music findById(int id) {
        //c1
//        return BaseRepository.entityManager.find(Music.class, id);

        //c2
        TypedQuery<Music> musicTypedQuery =
                BaseRepository.entityManager.createQuery(SELECT_MUSIC, Music.class);
        musicTypedQuery.setParameter("id", id);
        return musicTypedQuery.getSingleResult();
        //lay ra 1 ket qua
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        BaseRepository.entityManager.merge(music);

        entityTransaction.commit();
        //merge dung de cap nhat lai thong tin cua 1 row trong table
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Music.class, id));

        entityTransaction.commit();
        //remove dung de xoa 1 row ra khoi table
        //tham so truyen vao la 1 object
    }
}
