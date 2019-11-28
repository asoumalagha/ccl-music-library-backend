package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.SongAppUser;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        System.out.println("users " +userRepository.findAll());
        return userRepository.findAll();
    }

    public SongAppUser getUser(SongAppUser findUser) throws Exception {
        for (SongAppUser user: userRepository.findAll()) {
            if (user == findUser) {
                return user;
            }
        }
        throw new Exception();
    }

//    public List<User> getUsers(Long id) {
//        return userRepository.findAllById(id);
//    }

}
