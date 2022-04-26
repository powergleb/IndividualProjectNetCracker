package com.diary.DiaryProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
public class AddHomeworkController {

    @RequestMapping(value="/addHomework", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "addHomework";
    }

    @RequestMapping(value="/addHomework", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\groka\\OneDrive\\Desktop\\aa\\files\\" +file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                return "/index";
            } catch (Exception e) {
                model.addAttribute("fileError", "Вам не удалось загрузить  => " + e.getMessage());
                return "addHomework";
            }
        } else {
            model.addAttribute("fileError", "Вам не удалось загрузить потому что файл пустой.");
            return "addHomework";
        }
    }
}
