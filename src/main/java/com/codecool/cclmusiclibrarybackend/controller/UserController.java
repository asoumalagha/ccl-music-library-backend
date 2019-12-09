package com.codecool.cclmusiclibrarybackend.controller;

import com.codecool.cclmusiclibrarybackend.CclMusicLibraryBackendApplication;
import com.codecool.cclmusiclibrarybackend.model.SongAppUser;
import com.codecool.cclmusiclibrarybackend.service.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    @Autowired
    private UserHandler userHandler;

    //Get users
    @GetMapping("/list")
    @CrossOrigin
    public List<SongAppUser> userList(){
        return userHandler.getUsers();
    }

    //Add new user
    @PostMapping("/add")
    @CrossOrigin
    public void addUser(@RequestBody SongAppUser user){
        userHandler.addUser(user);
    }

    //Delete user
    @GetMapping("/{id}")
    @CrossOrigin
    public List<SongAppUser> searchForUser(@PathVariable("id") Long id){
        return userHandler.getUser(id);
    }
}
