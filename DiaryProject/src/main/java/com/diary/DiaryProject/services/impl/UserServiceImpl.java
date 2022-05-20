package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.RoleRepository;
import com.diary.DiaryProject.dao.repositories.StudentRepository;
import com.diary.DiaryProject.dao.repositories.TeacherRepository;
import com.diary.DiaryProject.entities.Role;
import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.entities.User;
import com.diary.DiaryProject.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@NoArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public boolean registerUser(User user, boolean isAdmin) {
        user.setPass(passwordEncoder.encode(user.getPass()));
        if (user instanceof Teacher && !isAdmin) {
            user.setRoles(Collections.singletonList(getTeachersRole()));
            teacherRepository.save((Teacher) user);
        } else if (user instanceof Teacher && isAdmin) {
            user.setRoles(Collections.singletonList(getAdminRole()));
            teacherRepository.save((Teacher) user);
        } else if (user instanceof Student) {
            user.setRoles(Collections.singletonList(getStudentsRole()));
            studentRepository.save((Student) user);
        } else {
            return false;
        }
        return true;
    }

    public UserDetails loadUserByUsername(String username) {
        User student = studentRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        User teacher = teacherRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        if (student != null) {
            return toSpringUser(student);
        } else if (teacher != null) {
            return toSpringUser(teacher);
        } else {
            return null;
        }
    }
    public User loadUserByUsernameEntity(String username) {
        User student = studentRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        User teacher = teacherRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        if (student != null) {
            return student;
        } else if (teacher != null) {
            return teacher;
        } else {
            return null;
        }
    }


    private org.springframework.security.core.userdetails.User toSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPass(),
                user.getRoles()
        );
    }

    private Role getStudentsRole() {
        return getRole("STUDENT");
    }

    private Role getAdminRole() {
        return getRole("ADMIN");
    }

    private Role getTeachersRole() {
        return getRole("TEACHER");
    }

    private Role getRole(String roleName) {
        Optional<Role> roleUser = roleRepository.findByName(roleName);
        if (!roleUser.isPresent()) {
            Role role = new Role(roleName);
            roleRepository.save(role);

            return role;
        }
        return roleUser.get();
    }

}