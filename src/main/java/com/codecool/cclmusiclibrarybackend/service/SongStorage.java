package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongStorage {
    private List<Song> songs = new ArrayList<>();

    @Autowired
    private SongCreator songCreator;

    public SongStorage() {
        this.songs.add(new Song("bla", "bla","bla",2));
        //this.songs.add(songCreator.createSong("bla","bla","bla",2));
    }

    public Song addSong(Song song){
        this.songs.add(song);
        return song;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void deleteSong(String title){
        for(Song song:songs){
            if (song.getTitle().equals(title)){
                songs.remove(song);
            }
        }
    }
}
