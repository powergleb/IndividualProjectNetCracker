package com.diary.DiaryProject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "numberOfGroup")
    public int numberOfGroup;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

}
