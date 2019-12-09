package com.codecool.cclmusiclibrarybackend.controller;

import com.codecool.cclmusiclibrarybackend.CclMusicLibraryBackendApplication;
import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.service.SongHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
@CrossOrigin
public class SongController {

    private final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    @Autowired
    private SongHandler songHandler;



    @GetMapping
    public List<Song> getSongsFromAPI(){
        return songHandler.getSongsFromAPI();
    }


    @GetMapping("/{id}")
    public List<Song> getSongsByUserId(@PathVariable("id") Long id){
        return songHandler.getSongsByUserId(id);
    }


    @GetMapping("/search/{search}")
    public List<Song> searchForSong(@PathVariable("search") String search){
        return songHandler.getSearchResult(search);
    }


    @PostMapping("/{id}")
    public void addSongToUser(@PathVariable("id") Long id, @RequestBody Song song){
        try {
            songHandler.addSongToUser(song, id);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deleteSongFromUser(@PathVariable("id") Long id, @RequestBody Long songId){
        try {
            songHandler.deleteSongFromUser(id, songId);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }

}
