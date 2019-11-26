package com.codecool.cclmusiclibrarybackend.service;



import com.codecool.cclmusiclibrarybackend.model.User;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        User newUser = User.builder().username(username)
                                     .password(passwordEncoder.encode(password))
                                     .firstName(firstName)
                                     .lastName(lastName)
                                     .email(email)
                                     .build();
        userRepository.save(newUser);
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

//    public List<User> getUsers(Long id) {
//        return userRepository.findAllById(id);
//    }

}
