package com.diary.DiaryProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "marks")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;


    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "value")
    private Double value;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "answerId")
    private Answer answer;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;


}
