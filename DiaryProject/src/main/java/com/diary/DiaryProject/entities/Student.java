package com.diary.DiaryProject.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;


@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "groupId")
    Group group;

    @OneToMany(mappedBy = "student")
    private List<Answer> answers;

    public Student(String name, String secondName, String patronymic, String pass, String login, String phone, String address, String mail, Group group) {
        super(name, secondName, patronymic, pass, login, phone, address, mail);
        this.group = group;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
