package com.diary.DiaryProject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "teachers")
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private List<Homework> homeworks;
}