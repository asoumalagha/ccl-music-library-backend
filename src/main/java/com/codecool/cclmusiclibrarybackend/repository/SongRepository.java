package com.codecool.cclmusiclibrarybackend.repository;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Transactional
    Song findSongByTitleAndAlbumAndPerformerAndLength(String title, String album, String performer, double length);



}


