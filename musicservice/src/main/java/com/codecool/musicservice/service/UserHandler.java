package com.codecool.musicservice.service;


import com.codecool.musicservice.model.SongAppUser;
import com.codecool.musicservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserHandler {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserHandler() {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void addUser(String username, String password, String firstName, String lastName, String email) {
        SongAppUser newTodoAppUser = SongAppUser.builder().userName(username)
                                     .password(passwordEncoder.encode(password))
                                     .firstName(firstName)
                                     .lastName(lastName)
                                     .email(email)
                                     .build();
        userRepository.save(newTodoAppUser);
    }

    public void addUser(SongAppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<SongAppUser> getUsers() {
        System.out.println("users " + userRepository.findAll());
        return userRepository.findAll();
    }

    public List<SongAppUser> getUser(Long id){
        return userRepository.findAllById(id);
    }

    public Optional<SongAppUser> getUserByUserName(String userName) {
        log.info(userName);
        return userRepository.findByUserName(userName);
    }
}
