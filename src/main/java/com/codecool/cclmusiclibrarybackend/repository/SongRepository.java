package com.codecool.cclmusiclibrarybackend.repository;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Transactional
    void deleteSongById(Long id);

    @Transactional
    List<Song> findAllByAlbum(String album);

    @Transactional
    List<Song> findAllByPerformer(String performer);

    @Transactional
    List<Song> findAllByTitle(String title);
}
