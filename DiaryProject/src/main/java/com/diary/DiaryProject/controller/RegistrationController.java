package com.diary.DiaryProject.controller;


import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.entities.Teacher;

import com.diary.DiaryProject.services.UserService;
import com.diary.DiaryProject.services.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupServiceImpl groupService;

    @GetMapping("/registrationStudent")
    public String registrationStudent(Model model) {
        model.addAttribute("studentForm", new Student());
        model.addAttribute("groupForm", groupService.readAllGroup());
        return "registrationStudent";
    }

    @GetMapping("/registrationBase")
    public String registrationBase() {
        return "registrationBase";
    }

    @PostMapping("/registrationStudent")
    public String addStudent(@ModelAttribute("studentForm") @Valid Student studentForm, BindingResult bindingResult, Model model) throws Exception {
        if (studentForm.getGroup()==null) {
            model.addAttribute("groupError", "Вы не выбрали группу");
            model.addAttribute("groupForm", groupService.readAllGroup());
            return "registrationStudent";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("groupForm", groupService.readAllGroup());
            return "registrationStudent";
        }

        if (!studentForm.getPass().equals(studentForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            model.addAttribute("groupForm", groupService.readAllGroup());
            return "registrationStudent";
        }

        if (userService.loadUserByUsername(studentForm.getLogin()) != null){
            model.addAttribute("loginError", "Пользователь с таким именем уже существует");
            model.addAttribute("groupForm", groupService.readAllGroup());
            return "registrationStudent";
        }
        if (!userService.registerUser(studentForm, false)) {
            model.addAttribute("loginError", "Пользователь с таким именем уже существует");
            model.addAttribute("groupForm", groupService.readAllGroup());
            return "registrationStudent";
        }
        return "redirect:/";
    }

    @GetMapping("/registrationTeacher")
    public String registrationTeacher(Model model) {
        model.addAttribute("teacherForm", new Teacher());
        return "registrationTeacher";
    }

    @PostMapping("/registrationTeacher")
    public String addTeacher(@ModelAttribute("teacherForm") @Valid Teacher teacherForm, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "registrationTeacher";
        }
        if (!teacherForm.getPass().equals(teacherForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registrationTeacher";
        }
        if (userService.loadUserByUsername(teacherForm.getLogin()) != null){
            model.addAttribute("loginError", "Пользователь с таким именем уже существует");
            return "registrationTeacher";
        }
        if (!userService.registerUser(teacherForm, false)) {
            return "registrationTeacher";
        }
        return "redirect:/";
    }
}