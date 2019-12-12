package com.codecool.musicservice.controller;

import com.codecool.musicservice.MusicServiceApplication;
import com.codecool.musicservice.model.Song;
import com.codecool.musicservice.service.SongHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
@CrossOrigin
@Slf4j
public class SongController {

    private final Logger LOGGER = LoggerFactory.getLogger(MusicServiceApplication.class);

    @Autowired
    private SongHandler songHandler;

    @GetMapping
    @CrossOrigin
    public List<Song> getSongsFromAPI(){
        return songHandler.getSongsFromAPI();
    }


    @GetMapping("/user/{username}")
    public List<Song> getSongsByUserName(@PathVariable("username") String username){
        return songHandler.getSongsByUserName(username);
    }


    @GetMapping("/search/{search}")
    public List<Song> searchForSong(@PathVariable("search") String search){
        return songHandler.getSearchResult(search);
    }


    @PostMapping("/user/{username}")
    public void addSongToUser(@PathVariable("username") String username, @RequestBody Song song){
        try {
            songHandler.addSongToUser(song, username);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

    @DeleteMapping("/user/{username}")
    public void deleteSongFromUser(@PathVariable("username") String username, @RequestBody Song song){
        try {
            songHandler.deleteSongFromUser(username, song);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

}
