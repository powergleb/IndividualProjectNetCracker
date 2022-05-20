package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

    public Answer createAnswer(Answer answer);

    public Answer readAnswer(int id);

    public Answer updateAnswer(Answer answer);

    public void deleteAnswer(int id);

    public List<Answer> readAllAnswer();

}
