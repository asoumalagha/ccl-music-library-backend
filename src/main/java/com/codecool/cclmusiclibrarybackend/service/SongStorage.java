package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.model.api.ApiResponse;
import com.codecool.cclmusiclibrarybackend.model.api.Response;
import com.codecool.cclmusiclibrarybackend.model.api.SongsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class SongStorage {

    @Autowired
    private ApiConnectionCreator apiConnectionCreator;

    private List<Song> songs = new LinkedList<>();

    public List<Song> getSongs() {
        return songs;
    }

    public Song addSong(Song song) {
        this.songs.add(song);
        return song;
    }

    public void deleteSong(String title) {
        Iterator<Song> iterator = songs.iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            if (song.getTitle().equals(title)) {
                songs.remove(song);
                break;
            }
        }
    }

    public List<Song> getSongsFromAPI() {
        ApiResponse apiResponse = apiConnectionCreator.getJsonFromAPI( "https://genius.p.rapidapi.com/artists/16775/songs");
        Response response = apiResponse.getResponse();
        List<SongsItem> songItems = response.getSongs();
        List<Song> songs = new LinkedList<>();
        for (SongsItem song: songItems){
            songs.add(new Song(song.getTitle(), "something", song.getPrimaryArtist().getName(),2 ));
        }
        return songs;
    }
}
