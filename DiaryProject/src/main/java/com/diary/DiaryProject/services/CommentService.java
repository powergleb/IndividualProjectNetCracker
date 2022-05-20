package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CommentService {

    public Comment createComment(Comment comment);

    public Comment readComment(int id);

    public Comment updateComment(Comment comment);

    public void deleteComment(int id);

    public List<Comment> readAllComment();

}