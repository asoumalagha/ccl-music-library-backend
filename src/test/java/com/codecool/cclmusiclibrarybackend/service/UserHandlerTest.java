package com.codecool.cclmusiclibrarybackend.service;

import com.codecool.cclmusiclibrarybackend.model.User;
import com.codecool.cclmusiclibrarybackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserHandlerTest {

    @Autowired
    private UserHandler userHandler;

    @Autowired
    private UserRepository userRepository;

    private User example = User.builder()
            .username("Példa")
            .password("geza")
            .firstName("Példa")
            .lastName("Géza")
            .email("pelda@geza.hu")
            .build();

    @Test
    public void testAddUserByObject(){
        userHandler.addUser(example);
        List<User> users = userRepository.findAll();
        assertEquals(2, users.size());
        userRepository.delete(example);
    }

    @Test
    public void testAddUserByHand(){
        userHandler.addUser("Mégegy", "megegy", "Mégegy", "és", "meg@egy.hu");
        List<User> users = userRepository.findAll();
        assertEquals(2, users.size());
    }


}