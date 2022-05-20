package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.FileInfoRepository;
import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.util.FileManager;

import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service("fileServiceImpl")
@NoArgsConstructor
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    public FileInfoRepository fileInfoRepository;

    public FileManager fileManager = new FileManager();

    @Transactional(rollbackFor = {IOException.class})
    @Override
    public FileInfo upload(MultipartFile resource) throws IOException {
        String key = generateKey(resource.getName());
        FileInfo createdFile = FileInfo.builder()
                .name(resource.getOriginalFilename())
                .key(key)
                .uploadDate(LocalDate.now())
                .size(resource.getSize())
                .build();
        createdFile = fileInfoRepository.save(createdFile);
        fileManager.upload(resource.getBytes(), key);

        return createdFile;
    }
    public void updateFile(Homework homework){
        for (FileInfo fileInfo : homework.getFileInfoList()){
            fileInfo.setFileContainer(homework);
        }
    }
    public void updateFile(Answer answer){
        for (FileInfo fileInfo : answer.getFileInfoList()){
            fileInfo.setFileContainer(answer);
        }
    }
    private String generateKey(String name) {
        return DigestUtils.md5Hex(name + LocalDateTime.now().toString());
    }


    @Override
    public Resource download(String key) throws IOException {
        return fileManager.download(key);
    }

    @Transactional(readOnly = true)
    @Override
    public FileInfo findById(Integer fileId) {
        return fileInfoRepository.getById(fileId);
    }
}
