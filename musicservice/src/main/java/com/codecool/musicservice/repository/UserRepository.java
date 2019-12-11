package com.codecool.musicservice.repository;

import com.codecool.musicservice.model.SongAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<SongAppUser, Long> {

    Optional<SongAppUser> findByUserName(String userName);


    @Transactional
    List<SongAppUser> findAllById(Long id);

}
