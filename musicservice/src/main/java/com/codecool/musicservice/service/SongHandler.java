package com.codecool.musicservice.service;


import com.codecool.musicservice.model.Song;
import com.codecool.musicservice.model.SongAppUser;
import com.codecool.musicservice.model.playlist.DataItem;
import com.codecool.musicservice.model.playlist.Playlist;
import com.codecool.musicservice.model.playlist.Tracks;
import com.codecool.musicservice.model.search.Search;
import com.codecool.musicservice.model.search.SearchItem;
import com.codecool.musicservice.repository.SongRepository;
import com.codecool.musicservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class SongHandler {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ApiConnectionCreator apiConnectionCreator;

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random();

    @Autowired
    private RestTemplate restTemplate;

    public void addSong(String title, String album, String performer, double length) {
        Song newSong = Song.builder().title(title)
                .album(album)
                .performer(performer)
                .length(length)
                .build();
        songRepository.save(newSong);
    }


    public void addSongToUser(Song song, String username) {
        if(getSong(song.getTitle(), song.getAlbum(), song.getPerformer(), song.getLength()) != null){
            addSongToUserPlaylist(song, username);

        }
        else{
            songRepository.save(song);
            addSongToUserPlaylist(song, username);
        }
    }

    private void addSongToUserPlaylist(Song song, String username){
        SongAppUser user = userRepository.findSongAppUserByUserName(username);
        user.getSongs().add(song);
        userRepository.save(user);
        restTemplate.postForObject("http://voteservice/vote/setDefault/" + song.getId(), song.getId(), Void.class);
    }

    public Song getSong(String title, String album, String performer, double length){
        return songRepository.findSongByTitleAndAlbumAndPerformerAndLength(title, album,performer,length);
    }

    public List<Song> getSongsByUserName(String username) {
        SongAppUser user = userRepository.findSongAppUserByUserName(username);
        return user.getSongs();
    }

    public void deleteSongFromUser(String username, Long songId) {
        Song song = songRepository.getOne(songId);
        SongAppUser user = userRepository.findSongAppUserByUserName(username);
        user.getSongs().remove(song);
        userRepository.save(user);
        if (song.getOwners().size() == 0){
            songRepository.delete(song);
        }
    }

    public void deleteSongFromUser(String username, Song song) {
        SongAppUser user = userRepository.findSongAppUserByUserName(username);
        user.getSongs().remove(song);
        userRepository.save(user);
        if (song.getOwners().size() == 0){
            songRepository.delete(song);
        }
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
