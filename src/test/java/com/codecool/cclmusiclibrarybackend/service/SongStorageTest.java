package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.Song;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

//@RunWith(MockitoJUnitRunner.class)
public class SongStorageTest {

    @Autowired
    private SongStorage songStorage;

    @Autowired
    private Song song1;

    @Autowired
    private Song song2;

    @Test
    void testSongStorageHasSongs(){
        Mockito.when(songStorage.getSongs()).thenReturn(Arrays.asList(song1, song2));
        Assert.assertNotEquals(0, songStorage.getSongs().size());
    }
}