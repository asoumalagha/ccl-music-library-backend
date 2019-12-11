package com.codecool.musicservice.repository;

import com.codecool.musicservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface SongRepository extends JpaRepository<Song, Long> {

    @Transactional
    Song findSongByTitleAndAlbumAndPerformerAndLength(String title, String album, String performer, double length);




}

