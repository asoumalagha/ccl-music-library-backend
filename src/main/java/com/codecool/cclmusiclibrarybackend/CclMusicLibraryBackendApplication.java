package com.codecool.cclmusiclibrarybackend;

import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.service.SongHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CclMusicLibraryBackendApplication {

    @Autowired
    private SongHandler songHandler;

    private static final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CclMusicLibraryBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        songHandler.addSong("example", "example", "example", 6);
        try {
            Song song = songHandler.getSong("example", "example", "example", 6);
            LOGGER.info(song.toString());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    };
}
