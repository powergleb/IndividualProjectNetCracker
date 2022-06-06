package com.diary.DiaryProject.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    @NotEmpty
    @Size(min = 2, message = "Имя не может быть меньше двух знаков")
    public String name;

    @Column(name = "secondName")
    @NotEmpty
    @Size(min = 2, message = "Фамилия не может быть меньше двух знаков")
    public String secondName;

    @Column(name = "patronymic")
    @NotEmpty
    @Size(min = 2, message = "Отчество не может быть меньше двух знаков")
    public String patronymic;

    @Column(name = "pass")
    @NotEmpty
    @Size(min = 2, message = "Пароль не может быть меньше двух знаков")
    public String pass;

    @Column(name = "login")
    @NotEmpty
    @Size(min = 2, message = "Логин не может быть меньше двух знаков")
    public String login;

    @Column(name = "phone")
    @NotEmpty
    @Size(min = 11,max = 11,message = "Некорректный формат телефона")
    public String phone;

    @Column(name = "address")
    @NotEmpty
    @Size(min = 2, message = "Адресс не может быть меньше двух знаков")
    public String address;

    @Column(name = "mail")
    @Email
    @NotEmpty
    public String mail;

    @Transient
    @NotEmpty
    @Size(min = 2, message = "Пароль не может быть меньше двух знаков")
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usersRoles",
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id"))
    private List<Role> roles;


}