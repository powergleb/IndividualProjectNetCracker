package com.diary.DiaryProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.GregorianCalendar;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;


    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "commentText")
    @NotEmpty
    private String commentText;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "answerId")
    private Answer answer;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;


}
