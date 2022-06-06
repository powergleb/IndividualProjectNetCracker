package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAnswerByHomework_Id(int id);
}