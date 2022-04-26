package com.diary.DiaryProject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
