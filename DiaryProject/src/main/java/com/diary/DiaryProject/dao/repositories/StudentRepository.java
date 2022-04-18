package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}