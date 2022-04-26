package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.FileForHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileForHomeworkRepository extends JpaRepository<FileForHomework, Integer> {

}