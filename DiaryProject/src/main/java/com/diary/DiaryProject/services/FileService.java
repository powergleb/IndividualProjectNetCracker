package com.diary.DiaryProject.services;


import com.diary.DiaryProject.entities.FileInfo;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {

    FileInfo upload(MultipartFile resource) throws IOException;

    Resource download(String key) throws IOException;

    FileInfo findById(Integer fileId);
}
