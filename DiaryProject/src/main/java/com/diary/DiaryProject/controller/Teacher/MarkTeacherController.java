package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.Mark;
import com.diary.DiaryProject.entities.User;
import com.diary.DiaryProject.services.MarkService;
import com.diary.DiaryProject.services.UserService;
import com.diary.DiaryProject.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.GregorianCalendar;
import java.util.Map;

@Controller
public class MarkTeacherController {


    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private MarkServiceImpl markService;
    @Autowired
    FileServiceImpl fileService;
    @PostMapping("/createMarkTeacher={idAnswer}")
    public String addMark(@ModelAttribute("markForm") @Valid Mark markForm, BindingResult bindingResult,
                          @PathVariable("idAnswer") Integer id, Model model,
                          RedirectAttributes redirectAttributes) throws Exception {
        if (bindingResult.hasErrors()) {
            //model.addAttribute("valueError",bindingResult.getFieldError("value").getDefaultMessage() );
            redirectAttributes.addFlashAttribute("valueError", bindingResult.getFieldError("value").getDefaultMessage());
            return "redirect:/answerViewTeacher="+id;
        }
        markForm.setAnswer(answerService.readAnswer(id));
        GregorianCalendar gcalendar = new GregorianCalendar();
        markForm.setDate(gcalendar);
        markService.createMark(markForm);
        return "redirect:/answerViewTeacher="+id;
    }
}