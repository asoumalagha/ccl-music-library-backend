package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongHandler {

    @Autowired
    private SongRepository SongRepository;

    public void addSong(String title, String album, String performer, double length) {
        Song newSong = Song.builder().title(title)
                             .album(album)
                             .performer(performer)
                             .length(length)
                             .build();
        SongRepository.save(newSong);
    }

    public void addSong(Song song) {
        SongRepository.save(song);
    }

    public Song getSong(String title, String album, String performer, double length) throws Exception {
        for (Song song: SongRepository.findAll()) {
            if (song.getTitle().equals(title) &&
                song.getAlbum().equals(album) &&
                song.getPerformer().equals(performer) && song.getLength() == length) {
                return song;
            }
        }
        throw new Exception();
    }

    public Song getSong(Song songToFind) throws Exception {
        for (Song song: SongRepository.findAll()) {
            if (song == songToFind) {
                return song;
            }
        }
        throw new Exception();
    }

    public List<Song> getSongs() {
        return SongRepository.findAll();
    }

    public void deleteSong(String title) {

    }
}
