package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student createStudent(Student student);

    Student readStudent(int id);

    Student updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> readAllStudent();

    Student getStudentByUsername(String username);


}