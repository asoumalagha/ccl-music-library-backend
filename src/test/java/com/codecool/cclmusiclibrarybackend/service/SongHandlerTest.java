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


    @Test
    public void testGetAllSongs(){
        List<Song> songs = songHandler.getSongs();
        assertTrue(songs.size()>0);
    }

    @Test
    public void testGetSongByParameters() throws Exception {
        Song song1 = Song.builder()
                .id((long) 1)
                .title("example")
                .length(6)
                .album("example")
                .performer("example")
                .build();
        Song foundedSong = songHandler.getSong("example", "example","example", 6);
        assertEquals(song1, foundedSong);

    }

    @Test
    public void testGetSongByObject() throws Exception {
        Song song1 = Song.builder()
                .id((long) 1)
                .title("example")
                .length(6)
                .album("example")
                .performer("example")
                .build();
        Song foundedSong = songHandler.getSong(song1);
        assertEquals(song1, foundedSong);
    }

    @Test
    public void testDeleteSongById(){
        List<Song> songs = songHandler.getSongs();
        assertEquals(9, songs.size());
        songHandler.deleteSong((long) 2);
        songs = songHandler.getSongs();
        assertEquals(8, songs.size());
    }


}