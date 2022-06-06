package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.Mark;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MarkTeacherController {
    @Autowired
    private MarkService markService;
    @Autowired
    FileService fileService;

    @PostMapping("/createMarkTeacher={idAnswer}")
    public String addMark(@ModelAttribute("markForm") @Valid Mark markForm, BindingResult bindingResult,
                          @PathVariable("idAnswer") Integer id, Model model,
                          RedirectAttributes redirectAttributes) throws Exception {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("valueError", bindingResult.getFieldError("value").getDefaultMessage());
            return "redirect:/answerViewTeacher=" + id;
        }
        markService.createMark(markForm, id);
        return "redirect:/answerViewTeacher=" + id;
    }
}