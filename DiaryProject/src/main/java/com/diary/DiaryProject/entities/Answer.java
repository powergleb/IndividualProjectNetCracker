package com.diary.DiaryProject.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@NoArgsConstructor
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @OneToMany(mappedBy = "answer")
    private List<FileForAnswer> filesForAnswer;

    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "taskText")
    private String taskText;

    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
    private Mark mark;


    @OneToMany(mappedBy = "answer")
    private List<Comment> comments;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "homeworkId")
    private Homework homework;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<FileForAnswer> getFilesForAnswer() {
        return filesForAnswer;
    }

    public void setFilesForAnswer(List<FileForAnswer> filesForAnswer) {
        this.filesForAnswer = filesForAnswer;
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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}