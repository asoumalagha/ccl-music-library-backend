package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.User;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String username, String password, String firstName, String lastName, String email) {
        User newUser = User.builder().username(username)
                                     .password(password)
                                     .firstName(firstName)
                                     .lastName(lastName)
                                     .email(email)
                                     .build();
        userRepository.save(newUser);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

}
