package com.codecool.voteservice.repository;

import com.codecool.voteservice.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Transactional
    Vote findVoteBySongId(Long songId);

}
