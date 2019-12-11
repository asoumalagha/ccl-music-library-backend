package com.codecool.musicservice.service;

import com.codecool.musicservice.model.playlist.Playlist;
import com.codecool.musicservice.model.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConnectionCreator {

    @Autowired
    private RestTemplate restTemplate;

    public Playlist getJsonFromAPI(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "deezerdevs-deezer.p.rapidapi.com");
        headers.add("x-rapidapi-key", "0d3fb3a814msh43875e58bb25c00p1b1854jsna716108be29f");
        ResponseEntity<Playlist> response = restTemplate.exchange(
                path, HttpMethod.GET, new HttpEntity<>(headers),
                Playlist.class);
        return response.getBody();
    }

    public Search getSearchResults(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "deezerdevs-deezer.p.rapidapi.com");
        headers.add("x-rapidapi-key", "0d3fb3a814msh43875e58bb25c00p1b1854jsna716108be29f");
        ResponseEntity<Search> response = restTemplate.exchange(
                path, HttpMethod.GET, new HttpEntity<>(headers),
                Search.class);
        return response.getBody();
    }


}
