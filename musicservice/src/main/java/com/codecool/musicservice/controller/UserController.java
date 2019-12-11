package com.codecool.musicservice.controller;

import com.codecool.musicservice.MusicServiceApplication;
import com.codecool.musicservice.exception.UserNotFoundException;
import com.codecool.musicservice.model.SongAppUser;
import com.codecool.musicservice.service.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(MusicServiceApplication.class);

    @Autowired
    private UserHandler userHandler;

    @GetMapping("/list")
    @CrossOrigin
    public List<SongAppUser> userList(){
        return userHandler.getUsers();
    }


    @PostMapping("/add")
    @CrossOrigin
    public void addUser(@RequestBody SongAppUser user){
        userHandler.addUser(user);
    }

    @GetMapping("/search/{id}")
    @CrossOrigin
    public List<SongAppUser> searchForSong(@PathVariable("id") Long id){
        return userHandler.getUser(id);
    }

    @GetMapping("/{username}")
    @CrossOrigin
    public SongAppUser getUserByUserName(@PathVariable("username") String userName) throws UserNotFoundException {
        return userHandler.getUserByUserName(userName).orElseThrow(() -> new UserNotFoundException(userName));
    }
}
