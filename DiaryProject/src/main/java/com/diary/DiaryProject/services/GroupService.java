package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {

    Group createGroup(Group group);

    public Group readGroup(int id);

    public Group updateGroup(Group group);

    public void deleteGroup(int id);

    public List<Group> readAllGroup();

}
