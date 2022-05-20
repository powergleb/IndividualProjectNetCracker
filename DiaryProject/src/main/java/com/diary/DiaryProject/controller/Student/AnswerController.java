package com.diary.DiaryProject.controller.Student;

import com.diary.DiaryProject.dao.repositories.AnswerRepository;
import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    FileServiceImpl fileService;

    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private HomeworkServiceImpl homeworkService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/homework/addAnswer={id}", method = RequestMethod.GET)
    public String provideUploadInfo(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("answerForm", new Answer());
        model.addAttribute("homeworkid",id);
        return "/addAnswer";
    }

    @RequestMapping(value = "/answerViewStudent={id}", method = RequestMethod.GET)
    public String getAnswerViewSelection(Model model, @PathVariable("id") Integer id) {

        Answer answer = answerService.readAnswer(id);
        model.addAttribute("date", answer.getDate().getTime());
        model.addAttribute("text", answer.getTaskText());
        model.addAttribute("studentName", answer.getStudent().getName());
        model.addAttribute("studentSecondName", answer.getStudent().getSecondName());
        model.addAttribute("studentPatronymic", answer.getStudent().getPatronymic());
        model.addAttribute("answerFiles", answer.getFileInfoList());
        model.addAttribute("commentList", answer.getComments());
        if( answer.getMark() != null){
            model.addAttribute("mark", answer.getMark().getValue());
        }else{
            model.addAttribute("mark", null);
        }
        model.addAttribute("commentForm", new Comment());
        model.addAttribute("idAnswer",id);
        return "answerViewStudent";
    }

    @RequestMapping(value = "/homework/addAnswer={id}", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("files") MultipartFile[] files, @Valid Answer answerForm, Model model, @PathVariable("id") Integer id) {
        List<FileInfo> fileInfos = new ArrayList<FileInfo>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        answerForm.setId(0);
        for(MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    fileInfos.add(fileService.upload(file));

                } catch (Exception e) {
                    model.addAttribute("filesForAnswerError", "Вам не удалось загрузить  => " + e.getMessage());
                    return "/addAnswer";
                }
            } else {
                model.addAttribute("filesForAnswerError", "Вам не удалось загрузить потому что файл пустой.");
                return "/addAnswer";
            }
        }
        answerForm.setFileInfoList(fileInfos);
        GregorianCalendar gcalendar = new GregorianCalendar();
        answerForm.setDate(gcalendar);
        answerForm.setStudent((Student) userService.loadUserByUsernameEntity(auth.getName()));
        answerForm.setHomework(homeworkService.readHomework(id));
        answerService.createAnswer(answerForm);
        return "/index";
    }
}
