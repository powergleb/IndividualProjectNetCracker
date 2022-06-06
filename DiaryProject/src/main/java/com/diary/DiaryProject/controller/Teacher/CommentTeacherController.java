package com.diary.DiaryProject.controller.Teacher;

import com.diary.DiaryProject.entities.Answer;
import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.Mark;
import com.diary.DiaryProject.services.AnswerService;
import com.diary.DiaryProject.services.CommentService;
import com.diary.DiaryProject.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class CommentTeacherController {

    @Autowired
    private CommentService commentService;
    @Autowired
    FileService fileService;
    @Autowired
    private AnswerService answerService;

    @PostMapping("/createCommentTeacher={idAnswer}")
    public String addComment(@ModelAttribute("commentForm")@Valid Comment commentForm,BindingResult bindingResult, @PathVariable("idAnswer") Integer id, Model model) throws Exception {
//        if (commentForm.getCommentText()==null) {
//            model.addAttribute("commentTextError", "комментарий не может быть пустым");
//            return "redirect:/answerViewTeacher=" + id;
//        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("commentTextError", "комментарий не может быть пустым");
            return "redirect:/answerViewTeacher=" + id;
        }
        commentService.createComment(commentForm, id);
        return "redirect:/answerViewTeacher=" + id;
    }
}
