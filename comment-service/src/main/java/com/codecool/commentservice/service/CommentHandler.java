package com.codecool.commentservice.service;

import com.codecool.commentservice.model.Comment;
import com.codecool.commentservice.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentHandler {

    @Autowired
    private CommentRepository commentRepository;


    public void addComment(String comment, Long songId) {
        Comment addedComment = Comment.builder()
                .comment(comment)
                .songId(songId)
                .build();
        commentRepository.save(addedComment);
    }

    public void deleteComment(Long songId, Long commentId) {
        commentRepository.deleteByIdAndSongId(commentId, songId);
    }


    public Comment getComment(String comment, Long songId){
        return commentRepository.findCommentByCommentAndSongId(comment, songId);
    }

    public List<Comment> getCommentsBySongId(Long songId){
        return commentRepository.findCommentBySongId(songId);
    }
}
