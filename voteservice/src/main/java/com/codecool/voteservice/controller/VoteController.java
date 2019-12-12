package com.codecool.voteservice.controller;

import com.codecool.voteservice.model.Vote;
import com.codecool.voteservice.service.VoteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
@Slf4j
public class VoteController {

    @Autowired
    VoteHandler voteHandler;

    @GetMapping("/getVote/{songId}")
    public Vote getVote(@PathVariable("songId") Long songId) {
        return voteHandler.getVote(songId);
    }

    @PostMapping("/addVote/{songId}")
    public void addVote(@PathVariable("songId") Long songId, @RequestBody int voteValue) {
        try {
            voteHandler.addVote(songId, voteValue);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @PutMapping("/updateVote/{songId}")
    public void updateVote(@PathVariable("songId") Long songId, @RequestBody int voteValue) {
        try {
            voteHandler.updateVote(songId, voteValue);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
