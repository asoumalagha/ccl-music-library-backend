package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SongHandlerTest {

    @Autowired
    private SongHandler songHandler;

    @Autowired
    private SongRepository songRepository;

    private Song example = Song.builder()
            .id((long) 1)
            .title("example")
            .length(6)
            .album("example")
            .performer("example")
            .build();


    @Test
    public void testGetAllSongs(){
        List<Song> songs = songHandler.getSongs();
        assertEquals(9, songs.size());
    }

    @Test
    public void testGetSongByParameters() throws Exception {
        Song foundedSong = songHandler.getSong("example", "example","example", 6);
        assertEquals(example, foundedSong);
    }

    @Test
    public void testGetSongByObject() throws Exception {
        Song foundedSong = songHandler.getSong(example);
        assertEquals(example, foundedSong);
    }

    @Test
    public void testAddSong(){
        Song example = Song.builder()
                .id((long) 20)
                .title("example")
                .length(6)
                .album("example")
                .performer("example")
                .build();
        songHandler.addSong(example);
        int size = songHandler.getSongs().size();
        assertEquals(10, size);
        songRepository.delete(example);
    }

    @Test
    public void testDeleteSongById(){
        songRepository.save(example);
        songHandler.deleteSong((long) 20);
        List<Song> songs = songHandler.getSongs();
        assertEquals(9, songs.size());
    }


}