package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Homework;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeworkService {

    public Homework createHomework(Homework homework);

    public Homework readHomework(int id);

    public Homework updateHomework(Homework homework);

    public void deleteHomework(int id);

    public List<Homework> readAllHomework();

}

