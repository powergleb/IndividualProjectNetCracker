package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.FileForHomeworkRepository;
import com.diary.DiaryProject.entities.FileForHomework;
import com.diary.DiaryProject.services.FileForHomeworkService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
@Transactional
public class FileForHomeworkServiceImpl implements FileForHomeworkService {

    @Autowired
    public FileForHomeworkRepository fileForHomeworkRepository;

    @Override
    public FileForHomework createFileForHomework(FileForHomework fileForHomework) {
        return fileForHomeworkRepository.save(fileForHomework);
    }

    @Override
    public FileForHomework readFileForHomework(int id) {
        return fileForHomeworkRepository.getById(id);
    }

    @Override
    public FileForHomework updateFileForHomework(FileForHomework fileForHomework) {
        return fileForHomeworkRepository.save(fileForHomework);
    }

    @Override
    public void deleteFileForHomework(int id) {
        fileForHomeworkRepository.deleteById(id);
    }

    @Override
    public List<FileForHomework> readAllFileForHomework() {
        return fileForHomeworkRepository.findAll();
    }
}
