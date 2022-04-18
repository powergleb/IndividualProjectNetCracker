package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.GroupRepository;
import com.diary.DiaryProject.dao.repositories.StudentRepository;
import com.diary.DiaryProject.entities.Group;
import com.diary.DiaryProject.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    @Autowired
    public GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group readGroup(int id) {
        return groupRepository.getById(id);
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public List<Group> readAllGroup() {
        return groupRepository.findAll();
    }
}
