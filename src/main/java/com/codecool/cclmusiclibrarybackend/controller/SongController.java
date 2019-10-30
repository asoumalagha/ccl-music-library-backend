package com.codecool.cclmusiclibrarybackend.controller;

import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.service.SongStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
public class SongController {

    @Autowired
    private SongStorage songStorage;

    @GetMapping("/list")
    public List<Song> songList(){
        return songStorage.getSongs();
    }

    @PostMapping("/add")
    public Song addSong(@RequestBody Song song){
        return songStorage.addSong(song);
    }

    @DeleteMapping("/{title}")
    public List<Song> deleteSong(@PathVariable("title") String title) throws Exception{
        songStorage.deleteSong(title);
        return songStorage.getSongs();

    }

}
