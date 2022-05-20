package com.diary.DiaryProject.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.GregorianCalendar;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "value")
    @Max(value = 100, message = "не может быть больше 100")
    @Min(value = 0, message = "не может быть меньше 0")
    @NotNull(message = "Введите оценку")
    private Integer value;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "answerId", referencedColumnName = "id")
    private Answer answer;

}
