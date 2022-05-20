package com.diary.DiaryProject.util;




import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final String DIRECTORY_PATH = "C:\\Users\\groka\\OneDrive\\Desktop\\aa\\files\\";

    public void upload(byte[] resource, String keyName) throws IOException {
        Path path = Paths.get(DIRECTORY_PATH, keyName);
        Path file = Files.createFile(path);
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file.toString());
            stream.write(resource);
        } finally {
            stream.close();
        }
    }

    public Resource download(String key) throws IOException {
        Path path = Paths.get(DIRECTORY_PATH + key);
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new IOException();
        }
    }
}
