package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Group;
import com.diary.DiaryProject.entities.Homework;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

    public Answer createAnswer(Answer answer,List<FileInfo> fileInfos);

    public Answer readAnswer(int id);

    public Answer updateAnswer(Answer answer);

    public void deleteAnswer(int id);

    public List<Answer> readAllAnswer();

    public List<Answer> readAnswersOfHomework(Homework homework);

}
