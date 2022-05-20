package com.diary.DiaryProject.controller.Student;

import com.diary.DiaryProject.entities.Comment;
import com.diary.DiaryProject.entities.User;
import com.diary.DiaryProject.services.UserService;
import com.diary.DiaryProject.services.impl.AnswerServiceImpl;
import com.diary.DiaryProject.services.impl.CommentServiceImpl;
import com.diary.DiaryProject.services.impl.FileServiceImpl;
import com.diary.DiaryProject.services.impl.HomeworkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.GregorianCalendar;

@Controller
public class CommentStudentController {
    @Autowired
    private HomeworkServiceImpl homeworkService;
    @Autowired
    private UserService userService;

    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    FileServiceImpl fileService;
    @PostMapping("/createCommentStudent={idAnswer}")
    public String addComment(@ModelAttribute("commentForm") @Valid Comment commentForm, @PathVariable("idAnswer") Integer id, BindingResult bindingResult, Model model) throws Exception {
        commentForm.setAnswer(answerService.readAnswer(id));
        GregorianCalendar gcalendar = new GregorianCalendar();
        commentForm.setDate(gcalendar);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User cur =  userService.loadUserByUsernameEntity(auth.getName());
        commentForm.setUser(cur);

        commentService.createComment(commentForm);
        return "redirect:/answerViewStudent="+id;
    }
}
