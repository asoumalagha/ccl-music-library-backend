package com.codecool.apigateway.service;

import com.codecool.apigateway.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${musicservice.url}")
    private String baseUrl;

    public AppUser findUserByUserName(String username) {
        return restTemplate.getForObject(baseUrl + "/" + username, AppUser.class);
    }

}
