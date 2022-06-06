package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Mark;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.FileService;
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
public class AnswerTeacherController {


    @Autowired
    private AnswerService answerService;
    @Autowired
    private FileService fileService;


    @RequestMapping(value = "/answerViewTeacher={id}", method = RequestMethod.GET)
    public String getAnswerViewSelection(Model model, @PathVariable("id") Integer id) {

        Answer answer = answerService.readAnswer(id);
        model.addAttribute("date", answer.getDate().getTime());
        model.addAttribute("text", answer.getTaskText());
        model.addAttribute("studentName", answer.getStudent().getName());
        model.addAttribute("studentSecondName", answer.getStudent().getSecondName());
        model.addAttribute("studentPatronymic", answer.getStudent().getPatronymic());
        model.addAttribute("answerFiles", answer.getFileInfoList());
        if (answer.getMark() != null) {
            model.addAttribute("mark", answer.getMark().getValue());
        } else {
            model.addAttribute("mark", null);
        }
        model.addAttribute("markForm", new Mark());
        model.addAttribute("commentList", answer.getComments());
        model.addAttribute("commentForm", new Comment());


        model.addAttribute("idAnswer", id);
        return "answerViewTeacher";
    }


    @RequestMapping(value = "/downloadAnswerFiles={id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
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
