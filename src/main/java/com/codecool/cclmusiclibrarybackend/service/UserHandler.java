package com.codecool.cclmusiclibrarybackend.service;


import com.codecool.cclmusiclibrarybackend.model.TodoAppUser;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserHandler() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
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

    public void addUser(TodoAppUser todoAppUser) {
        userRepository.save(todoAppUser);
    }

}
