package com.codecool.cclmusiclibrarybackend.controller;

import com.codecool.cclmusiclibrarybackend.CclMusicLibraryBackendApplication;
import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.service.SongHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("songs")
@CrossOrigin
public class SongController {

    private final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    @Autowired
    private SongHandlers songHandlers;

    @GetMapping
    public List<Song> homePage(){
        return songHandlers.getSongsFromAPI();
    }
    @GetMapping("/list")
    public List<Song> songList(){
        return songHandlers.getSongs();
    }

    @GetMapping("/{search}")
    public Set<Song> searchForSong(@PathVariable("search") String search){
        return songHandlers.getSearchResult(search);
    }

    @PostMapping("/add")
    public Song addSong(@RequestBody Song song){
        songHandlers.addSong(song);
        try {
            return songHandlers.getSong(song);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public List<Song> deleteSong(@PathVariable("id") Long id) throws Exception{
        try {
            songHandlers.deleteSong(id);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return songHandlers.getSongs();

    }

}
