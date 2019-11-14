package com.codecool.cclmusiclibrarybackend.repository;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Transactional
    void deleteSongById(Long id);
}
