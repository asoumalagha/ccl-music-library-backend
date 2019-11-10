package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class SongStorage {
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
}
