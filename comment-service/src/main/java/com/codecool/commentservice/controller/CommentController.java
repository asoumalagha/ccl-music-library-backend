package com.codecool.commentservice.controller;

import com.codecool.commentservice.model.Comment;
import com.codecool.commentservice.service.CommentHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
@CrossOrigin
@Slf4j
public class CommentController {

    @Autowired
    private CommentHandler commentHandler;

    @GetMapping("/{songId}")
    public List<Comment> getCommentsBySongId(@PathVariable("songId") Long songId){
        log.info("comment");
        return commentHandler.getCommentsBySongId(songId);
    }

    @PostMapping("/{songId}")
    public void addCommentToSong(@PathVariable("songId") Long songId, @RequestBody String comment){
        try {
            commentHandler.addComment(comment, songId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @DeleteMapping("/{songId}/comment/{commentId}")
    public void deleteComment(@PathVariable("songId") Long songId, @PathVariable("commentId") Long commentId){
        try {
            commentHandler.deleteComment(commentId, songId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
