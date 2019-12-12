package com.codecool.commentservice.repository;

import com.codecool.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Transactional
    List<Comment> findCommentBySongId(Long songId);

    @Transactional
    void deleteByIdAndSongId(Long id, Long songId);

    List<Comment> findAll();

    @Transactional
    Comment findCommentByCommentAndSongId(String comment, Long songId);

}
