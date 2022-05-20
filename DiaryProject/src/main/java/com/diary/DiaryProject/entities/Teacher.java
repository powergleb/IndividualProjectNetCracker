package com.diary.DiaryProject.entities;


import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private List<Homework> homeworks;
}