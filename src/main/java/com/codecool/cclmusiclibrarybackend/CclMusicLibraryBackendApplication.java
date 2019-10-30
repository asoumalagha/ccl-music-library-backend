package com.codecool.cclmusiclibrarybackend;

import com.codecool.cclmusiclibrarybackend.service.SongCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CclMusicLibraryBackendApplication {

    @Autowired
    private SongCreator songCreator;

    private static final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CclMusicLibraryBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit(){
        LOGGER.info(songCreator.createSong("example", "example", "example", 6).toString());
    };
}
