package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.entities.Student;
import com.diary.DiaryProject.services.StudentService;
import com.diary.DiaryProject.dao.repositories.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {


    @Autowired
    public StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student readStudent(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> readAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentRepository.findAll().stream().filter(c -> c.getLogin().equals(username)).findFirst().orElse(null);
    }
}