package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.FileForAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileForAnswerRepository extends JpaRepository<FileForAnswer, Integer> {

}