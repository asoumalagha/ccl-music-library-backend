package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.api.ApiResponse;

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

    public ApiResponse getJsonFromAPI(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "genius.p.rapidapi.com");
        headers.add("x-rapidapi-key", "0d3fb3a814msh43875e58bb25c00p1b1854jsna716108be29f");
        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                path, HttpMethod.GET, new HttpEntity<>(headers),
                ApiResponse.class);
        return response.getBody();
    }

}
