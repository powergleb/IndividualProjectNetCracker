package com.diary.DiaryProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "groupId")
    Group group;

    @OneToMany(mappedBy = "student")
    private List<Answer> answers;

}
