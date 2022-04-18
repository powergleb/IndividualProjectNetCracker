package com.diary.DiaryProject.entities;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private List<Homework> homeworks;

    public Teacher(String name, String secondName, String patronymic, String pass, String login, String phone, String address, String mail, List<Homework> homeworks) {
        super(name, secondName, patronymic, pass, login, phone, address, mail);
        this.homeworks = homeworks;
    }

    public Teacher(List<Homework> homeworks) {
        this.homeworks = homeworks;
    }


    public List<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<Homework> homeworks) {
        this.homeworks = homeworks;
    }
}