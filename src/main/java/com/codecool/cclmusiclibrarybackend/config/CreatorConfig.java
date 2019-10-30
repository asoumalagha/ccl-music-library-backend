package com.codecool.cclmusiclibrarybackend.config;

import com.codecool.cclmusiclibrarybackend.service.SongCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatorConfig {

    @Bean
    public SongCreator createSongCreator(){
        return new SongCreator();
    }

}

