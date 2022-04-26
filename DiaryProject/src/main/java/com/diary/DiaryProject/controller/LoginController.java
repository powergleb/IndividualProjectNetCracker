package com.diary.DiaryProject.controller;


import com.diary.DiaryProject.controller.Forms.LoginForm;
import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @GetMapping("/j_spring_security_check")
    public String Login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

}
