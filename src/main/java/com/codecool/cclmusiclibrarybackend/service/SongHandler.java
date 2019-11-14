package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.model.api.ApiResponse;
import com.codecool.cclmusiclibrarybackend.model.api.Response;
import com.codecool.cclmusiclibrarybackend.model.api.SongsItem;
import com.codecool.cclmusiclibrarybackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongHandler {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ApiConnectionCreator apiConnectionCreator;

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
            if (song == songToFind) {
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

    public List<Song> getSongsFromAPI() {
        ApiResponse apiResponse = apiConnectionCreator.getJsonFromAPI( "https://genius.p.rapidapi.com/artists/16775/songs");
        Response response = apiResponse.getResponse();
        List<SongsItem> songItems = response.getSongs();
        List<Song> songs = new LinkedList<>();
        for (SongsItem song: songItems){
            songs.add(Song.builder()
                .title(song.getTitle())
                .album(song.getFullTitle())
                .performer(song.getPrimaryArtist().getName())
                .length(3)
                .build());
        }
        return songs;
    }

    public Set<Song> getSearchResult(String searchTag) {
        Set<Song> results = new HashSet<>();
        results.addAll(songRepository.findAllByPerformer(searchTag));
        results.addAll(songRepository.findAllByAlbum(searchTag));
        results.addAll(songRepository.findAllByTitle(searchTag));
        return results;
    }
}
