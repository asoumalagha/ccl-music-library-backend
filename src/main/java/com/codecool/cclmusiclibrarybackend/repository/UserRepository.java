package com.codecool.cclmusiclibrarybackend.repository;

import com.codecool.cclmusiclibrarybackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
