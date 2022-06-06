package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.GroupRepository;
import com.diary.DiaryProject.dao.repositories.StudentRepository;
import com.diary.DiaryProject.entities.Group;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("groupServiceImpl")
@NoArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    public GroupRepository groupRepository;

    @Autowired
    public UserService userService;

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

    @Override
    public List<Group> readGroupsForTeacher() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Teacher cur = (Teacher) userService.loadUserByUsernameEntity(auth.getName());
        List<Group> list = cur.getHomeworks().stream().map(x -> x.getGroup()).distinct().collect(Collectors.toList());
        return list;
    }
}
