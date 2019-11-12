package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.api.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConnectionCreator {

    @Autowired
    private RestTemplate restTemplate;

    public ApiResponse getJsonFromAPI(String path){
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(path, ApiResponse.class);
        return response.getBody();
    }

}
