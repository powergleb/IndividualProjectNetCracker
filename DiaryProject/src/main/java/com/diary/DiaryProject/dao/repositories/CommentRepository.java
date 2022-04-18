package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}