package com.diary.DiaryProject.services.impl;

import com.diary.DiaryProject.dao.repositories.HomeworkRepository;
import com.diary.DiaryProject.entities.FileInfo;
import com.diary.DiaryProject.entities.Homework;
import com.diary.DiaryProject.entities.Teacher;
import com.diary.DiaryProject.services.FileService;
import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.HomeworkService;
import com.diary.DiaryProject.services.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

@Service("homeworkServiceImpl")
@NoArgsConstructor
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    public HomeworkRepository homeworkRepository;
    @Autowired
    public FileService fileService;
    @Autowired
    public UserService userService;
    @Autowired
    public GroupService groupService;

    @Override
    public Homework createHomework(Homework homework,List<FileInfo> fileInfos) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        homework.setFileInfoList(fileInfos);
        GregorianCalendar gcalendar = new GregorianCalendar();
        homework.setDate(gcalendar);
        homework.setTeacher((Teacher) userService.loadUserByUsernameEntity(auth.getName()));
        Homework homework1 = homeworkRepository.save(homework);
        fileService.updateFile(homework);
        return homework1;
    }

    @Override
    public Homework readHomework(int id) {
        return homeworkRepository.getById(id);
    }

    @Override
    public Homework updateHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    @Override
    public void deleteHomework(int id) {
        homeworkRepository.deleteById(id);
    }

    @Override
    public List<Homework> readAllHomework() {
        return homeworkRepository.findAll();
    }

    @Override
    public List<Homework> getHomeworksForTeacherByGroup(int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Teacher cur = (Teacher) userService.loadUserByUsernameEntity(auth.getName());
        return homeworkRepository.getHomeworkByTeacher_IdAndGroup_Id(cur.getId(), id);
    }


}
