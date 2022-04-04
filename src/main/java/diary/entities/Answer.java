package diary.entities;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="studentId", nullable=false)
    private Student student;

    @OneToMany(mappedBy="answer", fetch=FetchType.EAGER)
    private List<FileForHomework> filesForAnswer;

    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "taskText")
    private String taskText;

    @OneToOne(mappedBy = "answer", cascade=CascadeType.ALL)
    private Mark mark;


    @OneToMany(mappedBy="answer", fetch=FetchType.EAGER)
    private List<FileForHomework> answers;


    @OneToMany(mappedBy="answer", fetch=FetchType.EAGER)
    private List<Comment> comments;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="homeworkId")
    private Homework homework;




    public void setValue(Class<?> type,
                         Homework homework,
                         String paramName,
                         String value) throws Exception {

        Field field;
        field = Homework.class.getField(paramName);

        if (field == null)
            throw new IllegalArgumentException(
                    "can't find the field with name: " + paramName);

        field.setAccessible(true);
        field.set(homework, value);
    }
}