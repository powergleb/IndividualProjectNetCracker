package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

}