package com.diary.DiaryProject.services;


import com.diary.DiaryProject.entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher createTeacher(Teacher teacher);

    public Teacher readTeacher(int id);

    public Teacher updateTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public List<Teacher> readAllTeacher();

    public Teacher getTeacherByUsername(String username);

}