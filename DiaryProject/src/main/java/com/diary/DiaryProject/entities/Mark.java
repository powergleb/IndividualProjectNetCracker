package com.diary.DiaryProject.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@NoArgsConstructor
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;


    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "value")
    private Double value;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "answerId", referencedColumnName = "id")
    private Answer answer;

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
}
