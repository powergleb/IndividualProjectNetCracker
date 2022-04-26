package com.diary.DiaryProject.entities;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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


}