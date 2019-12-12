package com.codecool.voteservice.controller;

import com.codecool.voteservice.model.Vote;
import com.codecool.voteservice.service.VoteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
@CrossOrigin
@Slf4j
public class VoteController {

    @Autowired
    VoteHandler voteHandler;

    @GetMapping("/setDefault/{songId}")
    public void setDefault(@PathVariable("songId") Long songId) {
        voteHandler.addVote(songId, 0);
    }

    @GetMapping("/{songId}")
    public Vote getVote(@PathVariable("songId") Long songId) {
        return voteHandler.getVote(songId);
    }

    @PostMapping("/{songId}")
    public void addVote(@PathVariable("songId") Long songId, @RequestBody int voteValue) {
        try {
            voteHandler.addVote(songId, voteValue);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @PutMapping("/{songId}")
    public void updateVote(@PathVariable("songId") Long songId, @RequestBody int voteValue) {
        try {
            voteHandler.updateVote(songId, voteValue);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
