package com.diary.DiaryProject.controller.Student;

import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommentStudentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/createCommentStudent={idAnswer}")
    public String addComment(@ModelAttribute("commentForm") @Valid Comment commentForm, @PathVariable("idAnswer") Integer id, BindingResult bindingResult, Model model) throws Exception {
        commentService.createComment(commentForm, id);
        return "redirect:/answerViewStudent=" + id;
    }
}
