package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.TeacherRepository;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.services.TeacherService;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    public TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher readTeacher(int id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> readAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherByUsername(String username) {
        return teacherRepository.findAll().stream().filter(d -> d.getLogin().equals(username)).findFirst().orElse(null);
    }

}