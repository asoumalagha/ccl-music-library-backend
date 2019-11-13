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

    @GetMapping("/list")
    public List<Song> songList(){
        return songHandler.getSongs();
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

    @DeleteMapping("/{title}")
    public List<Song> deleteSong(@PathVariable("title") String title) throws Exception{
        try {
            songHandler.deleteSong(title);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return songHandler.getSongs();

    }

}
