package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


@Controller
public class TeacherHomeworkViewController {
    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private FileService fileService;


    @RequestMapping(value = "/groupViewTeacher", method = RequestMethod.GET)
    public String getGroupViewSelection(Model model) {
        model.addAttribute("groupList", groupService.readGroupsForTeacher());
        return "groupViewTeacher";
    }

    @RequestMapping(value = "/homeworkListByGroup={id}", method = RequestMethod.GET)
    public String getHomeworkListByGroupView(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("homeworkList", homeworkService.getHomeworksForTeacherByGroup(id));
        model.addAttribute("group", groupService.readGroup(id).getNumberOfGroup());
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
        model.addAttribute("answerList", answerService.readAnswersOfHomework(homework));
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
