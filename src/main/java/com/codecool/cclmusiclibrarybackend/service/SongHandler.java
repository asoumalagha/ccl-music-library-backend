package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.model.playlist.DataItem;
import com.codecool.cclmusiclibrarybackend.model.playlist.Playlist;
import com.codecool.cclmusiclibrarybackend.model.playlist.Tracks;
import com.codecool.cclmusiclibrarybackend.model.search.Search;
import com.codecool.cclmusiclibrarybackend.model.search.SearchItem;
import com.codecool.cclmusiclibrarybackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongHandler {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ApiConnectionCreator apiConnectionCreator;

    private Random random = new Random();

    public void addSong(String title, String album, String performer, double length) {
        Song newSong = Song.builder().title(title)
                             .album(album)
                             .performer(performer)
                             .length(length)
                             .build();
        songRepository.save(newSong);
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public Song getSong(String title, String album, String performer, double length) throws Exception {
        for (Song song: songRepository.findAll()) {
            if (song.getTitle().equals(title) &&
                song.getAlbum().equals(album) &&
                song.getPerformer().equals(performer) && song.getLength() == length) {
                return song;
            }
        }
        throw new Exception();
    }

    public Song getSong(Song songToFind) throws Exception {
        for (Song song: songRepository.findAll()) {
            if (song == songToFind) {
                return song;
            }
        }
        throw new Exception();
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public void deleteSong(Long id) {
        songRepository.deleteSongById(id);
    }

    public List<Song> getSongsFromAPI() {
        int[] playlists = {12345,87621,87543};
        int id = random.nextInt(3);
        Playlist playList = apiConnectionCreator.getJsonFromAPI( "https://deezerdevs-deezer.p.rapidapi.com/playlist/"+playlists[id]);
        Tracks tracks = playList.getTracks();
        List<DataItem> dataItems = tracks.getData();
        List<Song> songs = new LinkedList<>();
        for (DataItem song: dataItems){
            songs.add(Song.builder()
                .title(song.getTitle())
                .album(song.getAlbum().getTitle())
                .performer(song.getArtist().getName())
                .length(song.getDuration())
                .build());
        }
        return songs;
    }

    public List<Song> getSearchResult(String searchTag) {
        Search search = apiConnectionCreator.getSearchResults("https://api.deezer.com/search?redirect_uri=http%253A%252F%252Fguardian.mashape.com%252Fcallback&q="+searchTag+"&index=25");
        List<SearchItem> dataItems = search.getData();
        List<Song> songs = new LinkedList<>();
        for (SearchItem song: dataItems){
            songs.add(Song.builder()
                    .title(song.getTitle())
                    .album(song.getAlbum().getTitle())
                    .performer(song.getArtist().getName())
                    .length(song.getDuration())
                    .build());
        }
        return songs;
    }
}
