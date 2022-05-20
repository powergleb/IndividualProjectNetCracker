package com.diary.DiaryProject.services.impl;


import com.diary.DiaryProject.dao.repositories.CommentRepository;
import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.services.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentServiceImpl")
@NoArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment readComment(int id) {
        return commentRepository.getById(id);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> readAllComment() {
        return commentRepository.findAll();
    }
}
