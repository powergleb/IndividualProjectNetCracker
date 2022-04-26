package com.diary.DiaryProject.dao.repositories;

import com.diary.DiaryProject.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}