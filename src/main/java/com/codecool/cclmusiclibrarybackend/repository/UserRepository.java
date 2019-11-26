package com.codecool.cclmusiclibrarybackend.repository;


import com.codecool.cclmusiclibrarybackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    List<User> findAllById(Long id);
}
