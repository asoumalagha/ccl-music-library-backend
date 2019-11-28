package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.TodoAppUser;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        TodoAppUser newTodoAppUser = TodoAppUser.builder().username(username)
                                     .password(passwordEncoder.encode(password))
                                     .firstName(firstName)
                                     .lastName(lastName)
                                     .email(email)
                                     .build();
        userRepository.save(newTodoAppUser);
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getUsers() {
        System.out.println("users " +userRepository.findAll());
        return userRepository.findAll();
    }

    public User getUser(User findUser) throws Exception {
        for (User user: userRepository.findAll()) {
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
