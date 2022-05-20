package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {

}