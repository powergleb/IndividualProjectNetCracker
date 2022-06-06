package com.diary.DiaryProject.controller.Teacher;


import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.HomeworkService;
import com.diary.DiaryProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class AddHomeworkController {
    @Autowired
    FileService fileService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private HomeworkService homeworkService;

    @RequestMapping(value = "/addHomework", method = RequestMethod.GET)
    public String provideUploadInfo(Model model) {
        model.addAttribute("homeworkForm", new Homework());
        model.addAttribute("groupForm", groupService.readAllGroup());
        return "addHomework";
    }

    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("files") MultipartFile[] files, Homework homeworkForm, Model model) {
        List<FileInfo> fileInfos = new ArrayList<FileInfo>();
        if (homeworkForm.getGroup() == null) {
            model.addAttribute("groupError", "Вы не выбрали группу");
            model.addAttribute("groupForm", groupService.readAllGroup());
            model.addAttribute("homeworkForm", new Homework());
            return "addHomework";
        }
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    fileInfos.add(fileService.upload(file));
                } catch (Exception e) {
                    model.addAttribute("fileInfoListError", "Вам не удалось загрузить  => " + e.getMessage());
                    model.addAttribute("groupForm", groupService.readAllGroup());
                    model.addAttribute("homeworkForm", new Homework());
                    return "addHomework";
                }
            } else {
                model.addAttribute("fileInfoListError", "Вам не удалось загрузить потому что файл пустой.");
                model.addAttribute("groupForm", groupService.readAllGroup());
                model.addAttribute("homeworkForm", new Homework());
                return "addHomework";
            }
        }
        homeworkService.createHomework(homeworkForm, fileInfos);
        return "/index";
    }
}
