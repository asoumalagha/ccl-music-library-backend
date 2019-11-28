package com.codecool.cclmusiclibrarybackend.repository;

import com.codecool.cclmusiclibrarybackend.model.TodoAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TodoAppUser, Long> {

    Optional<TodoAppUser> findByUsername(String username);

}
