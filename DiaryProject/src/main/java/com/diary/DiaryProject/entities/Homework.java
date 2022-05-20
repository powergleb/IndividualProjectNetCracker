package com.diary.DiaryProject.entities;


import com.diary.DiaryProject.entities.intefaces.FileContainer;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "homeworks")
public class Homework extends FileContainer {

    @ManyToOne
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private Group group;

}
