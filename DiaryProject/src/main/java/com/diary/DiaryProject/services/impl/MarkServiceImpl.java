package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.GroupRepository;
import com.diary.DiaryProject.dao.repositories.MarkRepository;
import com.diary.DiaryProject.entities.Group;
import com.diary.DiaryProject.entities.Mark;
import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.MarkService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("markServiceImpl")
@NoArgsConstructor
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    public MarkRepository markRepository;

    @Override
    public Mark createMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark readMark(int id) {
        return markRepository.getById(id);
    }

    @Override
    public Mark updateMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public void deleteMark(int id) {
        markRepository.deleteById(id);
    }

    @Override
    public List<Mark> readAllMark() {
        return markRepository.findAll();
    }
}
