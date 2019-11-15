package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongHandler {

    @Autowired
    private SongRepository songRepository;

    public void addSong(String title, String album, String performer, double length) {
        Song newSong = Song.builder().title(title)
                             .album(album)
                             .performer(performer)
                             .length(length)
                             .build();
        songRepository.save(newSong);
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public Song getSong(String title, String album, String performer, double length) throws Exception {
        for (Song song: songRepository.findAll()) {
            if (song.getTitle().equals(title) &&
                song.getAlbum().equals(album) &&
                song.getPerformer().equals(performer) && song.getLength() == length) {
                return song;
            }
        }
        throw new Exception();
    }

    public Song getSong(Song songToFind) throws Exception {
        for (Song song: songRepository.findAll()) {
            if (song.equals(songToFind)) {
                return song;
            }
        }
        throw new Exception();
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public void deleteSong(Long id) {
        songRepository.deleteSongById(id);
    }
}
