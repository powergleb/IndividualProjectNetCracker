package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.HomeworkRepository;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.services.HomeworkService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("homeworkServiceImpl")
@NoArgsConstructor
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    public HomeworkRepository homeworkRepository;
    @Autowired
    public FileServiceImpl fileService;
    @Override
    public Homework createHomework(Homework homework) {
        Homework homework1 = homeworkRepository.save(homework);
        fileService.updateFile(homework);
        return homework1;
    }

    @Override
    public Homework readHomework(int id) {
        return homeworkRepository.getById(id);
    }

    @Override
    public Homework updateHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    @Override
    public void deleteHomework(int id) {
        homeworkRepository.deleteById(id);
    }

    @Override
    public List<Homework> readAllHomework() {
        return homeworkRepository.findAll();
    }
}
