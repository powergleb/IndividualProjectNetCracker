package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    List<Homework> getHomeworkByTeacher_IdAndGroup_Id(int teacherId,int groupId);
}