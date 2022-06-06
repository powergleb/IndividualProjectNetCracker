package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.AnswerRepository;
import com.diary.DiaryProject.entities.*;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

@Service("answerServiceImpl")
@NoArgsConstructor
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    public AnswerRepository answerRepository;
    @Autowired
    public UserService userService;
    @Autowired
    public FileServiceImpl fileService;

    @Override
    public Answer createAnswer(Answer answer,List<FileInfo> fileInfos) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        answer.setFileInfoList(fileInfos);
        GregorianCalendar gcalendar = new GregorianCalendar();
        answer.setDate(gcalendar);
        answer.setStudent((Student) userService.loadUserByUsernameEntity(auth.getName()));
        Answer answer1 = answerRepository.save(answer);
        fileService.updateFile(answer);
        return answer1;
    }

    @Override
    public Answer readAnswer(int id) {
        return answerRepository.getById(id);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }

    @Override
    public List<Answer> readAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> readAnswersOfHomework(Homework homework) {
        return answerRepository.findAnswerByHomework_Id(homework.getId());
    }
}
