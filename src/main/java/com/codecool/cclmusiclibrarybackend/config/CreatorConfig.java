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
            songStorage.addSong(songCreator.createSong("Cherri cherri lady", "Let's talk about love", "Modern talking", 3.46));
            songStorage.addSong(songCreator.createSong("Relax", "Frankie goes to Hollywood", "example", 3.56));
            songStorage.addSong(songCreator.createSong("Toxic", "In the zone", "Britney Spears", 3.18));
            songStorage.addSong(songCreator.createSong("...Baby one more time", "Britney Spears", "Baby one more time", 3.31));
            songStorage.addSong(songCreator.createSong("Beautiful trauma", "What about us", "P!nk", 4.57));
            songStorage.addSong(songCreator.createSong("Just give me reasons", "Nate rules", "P!nk", 3.21));
            songStorage.addSong(songCreator.createSong("Manicure", "Art pop", "Lady Gaga", 3.19));
            songStorage.addSong(songCreator.createSong("Jump around", "House of Pain", "House of pain", 3.34));
        };

    }

}

