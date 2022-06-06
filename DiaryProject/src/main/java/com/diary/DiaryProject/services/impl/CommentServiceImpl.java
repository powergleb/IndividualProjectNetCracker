package com.diary.DiaryProject.services.impl;


import com.diary.DiaryProject.dao.repositories.CommentRepository;
import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.User;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.CommentService;
import com.diary.DiaryProject.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

@Service("commentServiceImpl")
@NoArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentRepository commentRepository;
    @Autowired
    public UserService userService;

    @Autowired
    public AnswerService answerService;

    @Override
    public Comment createComment(Comment comment, int answerID) {
        comment.setAnswer(answerService.readAnswer(answerID));
        GregorianCalendar gcalendar = new GregorianCalendar();
        comment.setDate(gcalendar);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User cur = userService.loadUserByUsernameEntity(auth.getName());
        comment.setUser(cur);
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
