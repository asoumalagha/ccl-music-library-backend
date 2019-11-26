package com.codecool.cclmusiclibrarybackend.config;

import com.codecool.cclmusiclibrarybackend.service.SongHandlers;
import com.codecool.cclmusiclibrarybackend.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CreatorConfig {

    @Autowired
    private SongHandlers songHandlers;

    @Autowired
    private UserHandler userHandler;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            songHandlers.addSong("Cherri cherri lady", "Let's talk about love", "Modern talking", 3.46);
            songHandlers.addSong("Relax", "Frankie goes to Hollywood", "example", 3.56);
            songHandlers.addSong("Toxic", "In the zone", "Britney Spears", 3.18);
            songHandlers.addSong("...Baby one more time", "Britney Spears", "Baby one more time", 3.31);
            songHandlers.addSong("Beautiful trauma", "What about us", "P!nk", 4.57);
            songHandlers.addSong("Just give me reasons", "Nate rules", "P!nk", 3.21);
            songHandlers.addSong("Manicure", "Art pop", "Lady Gaga", 3.19);
            songHandlers.addSong("Jump around", "House of Pain", "House of pain", 3.34);
            userHandler.addUser("testUser", "testPassword", "test", "User", "test@test.test");
        };

    }

}

