package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.*;

import com.diary.DiaryProject.services.UserService;
import com.diary.DiaryProject.services.impl.AnswerServiceImpl;
import com.diary.DiaryProject.services.impl.FileServiceImpl;
import com.diary.DiaryProject.services.impl.GroupServiceImpl;
import com.diary.DiaryProject.services.impl.HomeworkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class TeacherHomeworkViewController {
    @Autowired
    private HomeworkServiceImpl homeworkService;
    @Autowired
    private UserService userService;

    @Autowired
    private GroupServiceImpl groupService;

    @Autowired
    private AnswerServiceImpl answerService;
    @Autowired
    FileServiceImpl fileService;


    @RequestMapping(value = "/groupViewTeacher", method = RequestMethod.GET)
    public String getGroupViewSelection(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Teacher cur =  (Teacher) userService.loadUserByUsernameEntity(auth.getName());
        List<Group> list = cur.getHomeworks().stream().map(x->x.getGroup()).distinct().collect(Collectors.toList());
        model.addAttribute("groupList", list);
        return "groupViewTeacher";
    }
    @RequestMapping(value = "/homeworkListByGroup={id}", method = RequestMethod.GET)
    public String getHomeworkListByGroupView(Model model, @PathVariable("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Teacher cur =  (Teacher) userService.loadUserByUsernameEntity(auth.getName());
        List<Homework> list = cur.getHomeworks().stream().filter(x->x.getGroup()==groupService.readGroup(id)).collect(Collectors.toList());
        model.addAttribute("homeworkList", list);
        model.addAttribute("group",groupService.readGroup(id).getNumberOfGroup());
        return "homeworkListByGroup";
    }


    @RequestMapping(value = "/homeworkViewTeacher={id}", method = RequestMethod.GET)
    public String getHomeworkFromList(Model model, @PathVariable("id") Integer id) {
        Homework homework = homeworkService.readHomework(id);
        model.addAttribute("date", homework.getDate().getTime());
        model.addAttribute("text", homework.getTaskText());
        model.addAttribute("teacherName", homework.getTeacher().getName());
        model.addAttribute("teacherSecondName", homework.getTeacher().getSecondName());
        model.addAttribute("teacherPatronymic", homework.getTeacher().getPatronymic());
        model.addAttribute("homeworkFiles", homework.getFileInfoList());
        model.addAttribute("answerList", answerService.readAllAnswer().stream().filter(x->x.getHomework()==homework).collect(Collectors.toList()));
        model.addAttribute("homeworkid", homework.getId());
        return "homeworkViewTeacher";
    }
    @RequestMapping(value = "/downloadHomeworkTeacherFiles={id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadHomeworkFilesTeacher(@PathVariable("id") Integer id) {
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
