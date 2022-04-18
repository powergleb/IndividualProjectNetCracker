package com.diary.DiaryProject.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@NoArgsConstructor
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
