package com.diary.DiaryProject.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "taskText")
    private String taskText;

    @ManyToOne
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "homework")
    private List<FileForHomework> filesForHomework;

    @OneToMany(mappedBy = "homework")
    private List<FileForHomework> answers;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private Group group;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<FileForHomework> getFilesForHomework() {
        return filesForHomework;
    }

    public void setFilesForHomework(List<FileForHomework> filesForHomework) {
        this.filesForHomework = filesForHomework;
    }

    public List<FileForHomework> getAnswers() {
        return answers;
    }

    public void setAnswers(List<FileForHomework> answers) {
        this.answers = answers;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
