package com.diary.DiaryProject.controller;


import com.diary.DiaryProject.controller.Forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/j_spring_security_check")
    public String Login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

}
