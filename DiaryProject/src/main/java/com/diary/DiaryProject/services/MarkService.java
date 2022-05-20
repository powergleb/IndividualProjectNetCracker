package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Mark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarkService {

    public Mark createMark(Mark mark);

    public Mark readMark(int id);

    public Mark updateMark(Mark mark);

    public void deleteMark(int id);

    public List<Mark> readAllMark();

}
