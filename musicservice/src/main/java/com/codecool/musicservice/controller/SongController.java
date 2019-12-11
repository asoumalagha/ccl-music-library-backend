package com.codecool.musicservice.controller;

import com.codecool.musicservice.MusicServiceApplication;
import com.codecool.musicservice.model.Song;
import com.codecool.musicservice.service.SongHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
@CrossOrigin
public class SongController {

    private final Logger LOGGER = LoggerFactory.getLogger(MusicServiceApplication.class);

    @Autowired
    private SongHandler songHandler;

    @GetMapping
    public List<Song> homePage(){
        return songHandler.getSongsFromAPI();
    }

    @GetMapping("/list")
    public List<Song> songList(){
        return songHandler.getSongs();
    }

    @GetMapping("/search/{search}")
    public List<Song> searchForSong(@PathVariable("search") String search){
        return songHandler.getSearchResult(search);
    }

    @PostMapping("/add")
    public Song addSong(@RequestBody Song song){
        songHandler.addSong(song);
        try {
            return songHandler.getSong(song);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public List<Song> deleteSong(@PathVariable("id") Long id) throws Exception{
        try {
            songHandler.deleteSong(id);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return songHandler.getSongs();

    }

}
