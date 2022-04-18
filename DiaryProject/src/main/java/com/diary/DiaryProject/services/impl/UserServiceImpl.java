package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.TeacherRepository;
import com.diary.DiaryProject.dao.repositories.RoleRepository;
import com.diary.DiaryProject.dao.repositories.StudentRepository;
import com.diary.DiaryProject.entities.Role;
import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.entities.User;
import com.diary.DiaryProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user, boolean isAdmin) throws Exception {
        user.setPass(passwordEncoder.encode(user.getPass()));
        if (user instanceof Teacher && !isAdmin) {
            user.setRoles(Collections.singletonList(getDoctorsRole()));
            teacherRepository.save((Teacher) user);
        } else if (user instanceof Student && isAdmin) {
            user.setRoles(Collections.singletonList(getAdminRole()));
            studentRepository.save((Student) user);
        } else if (user instanceof Student) {
            user.setRoles(Collections.singletonList(getClientRole()));
            studentRepository.save((Student) user);
        } else {
            throw new Exception("Student can't be admin");
        }

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User student = studentRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        User teacher = teacherRepository.findAll().stream().
                filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
        if (student != null) {
            return toSpringUser(student);
        } else if (teacher != null) {
            return toSpringUser(teacher);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private org.springframework.security.core.userdetails.User toSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPass(),
                user.getRoles()
        );
    }

    private Role getClientRole() {
        return getRole("ROLE_CLIENT");
    }

    private Role getAdminRole() {
        return getRole("ROLE_ADMIN");
    }

    private Role getDoctorsRole() {
        return getRole("ROLE_DOCTOR");
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