package com.diary.DiaryProject.controller.Student;


import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.services.HomeworkService;
import com.diary.DiaryProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeworkViewController {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/homeworkListView", method = RequestMethod.GET)
    public String getHomeworkView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student cur = (Student) userService.loadUserByUsernameEntity(auth.getName());
        List<Homework> list = homeworkService.readAllHomework().stream()
                .filter(x -> x.getGroup() == cur.getGroup()).collect(Collectors.toList());
        model.addAttribute("homeworkList", list);
        return "homeworkListView";
    }

    @RequestMapping(value = "/homework={id}", method = RequestMethod.GET)
    public String getHomeworkFromList(Model model, @PathVariable("id") Integer id) {
        Homework homework = homeworkService.readHomework(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student cur = (Student) userService.loadUserByUsernameEntity(auth.getName());
        model.addAttribute("date", homework.getDate().getTime());
        model.addAttribute("text", homework.getTaskText());
        model.addAttribute("teacherName", homework.getTeacher().getName());
        model.addAttribute("teacherSecondName", homework.getTeacher().getSecondName());
        model.addAttribute("teacherPatronymic", homework.getTeacher().getPatronymic());
        model.addAttribute("homeworkFiles", homework.getFileInfoList());
        model.addAttribute("homeworkid", homework.getId());
        model.addAttribute("answerList", cur.getAnswers().stream().filter(x -> x.getHomework().equals(homework)).collect(Collectors.toList()));
        return "homeworkView";
    }

    @RequestMapping(value = "/downloadfiles={id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> download(@PathVariable("id") Integer id) {
        try {
            FileInfo foundFile = fileService.findById(id);
            Resource resource = fileService.download(foundFile.getKey());
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + foundFile.getName())
                    .body(resource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
