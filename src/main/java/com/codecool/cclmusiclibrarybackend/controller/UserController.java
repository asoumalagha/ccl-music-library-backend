package com.codecool.cclmusiclibrarybackend.controller;

import com.codecool.cclmusiclibrarybackend.CclMusicLibraryBackendApplication;
import com.codecool.cclmusiclibrarybackend.model.User;
import com.codecool.cclmusiclibrarybackend.service.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    @Autowired
    private UserHandler userHandler;

    @GetMapping("/list")
    public List<User> userList(){
        return userHandler.getUsers();
    }


    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user){
        userHandler.addUser(user);
        try {
            return userHandler.getUsers();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }
}
