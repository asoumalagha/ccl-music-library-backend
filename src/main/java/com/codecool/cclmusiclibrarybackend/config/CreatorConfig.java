package com.codecool.cclmusiclibrarybackend.config;

import com.codecool.cclmusiclibrarybackend.service.SongCreator;
import com.codecool.cclmusiclibrarybackend.service.SongStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatorConfig {

    @Autowired
    private SongStorage songStorage;

    @Autowired
    private SongCreator songCreator;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            songStorage.addSong(songCreator.createSong("example", "example", "example", 1));
        };

    }

}

