package com.codecool.voteservice.service;

import com.codecool.voteservice.model.Vote;
import com.codecool.voteservice.repository.VoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoteHandler {

    @Autowired
    private VoteRepository voteRepository;

    public Vote getVote(Long songId) {
        return voteRepository.findVoteBySongId(songId);
    }

    public void addVote(Long songId, int voteValue) {
        Vote newVote = Vote.builder()
                .rating(voteValue)
                .songId(songId)
                .build();
        voteRepository.save(newVote);
    }

    public void updateVote(Long songId, int voteValue) {
        Vote voteToUpdate = voteRepository.findVoteBySongId(songId);
        voteToUpdate.setRating(voteValue);
        voteRepository.save(voteToUpdate);
    }

}
