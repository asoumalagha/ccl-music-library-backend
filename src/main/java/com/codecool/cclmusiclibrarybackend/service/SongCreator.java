package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.Song;
import org.springframework.stereotype.Component;

@Component
public class SongCreator {

    public Song createSong(String title, String album, String performer, double length){
        return new Song(title, album, performer, length);
    }

}
