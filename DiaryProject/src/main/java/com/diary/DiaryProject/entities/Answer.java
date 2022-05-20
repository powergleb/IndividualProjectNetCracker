package com.diary.DiaryProject.entities;

import com.diary.DiaryProject.entities.intefaces.FileContainer;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "answers")
public class Answer extends FileContainer {

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
    private Mark mark;

    @OneToMany(mappedBy = "answer")
    private List<Comment> comments;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "homeworkId")
    private Homework homework;


}