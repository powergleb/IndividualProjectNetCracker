package diary.entities;



import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private GregorianCalendar date;

    @Column(name = "taskText")
    private String taskText;

    @ManyToOne
    @JoinColumn(name="teacherId", nullable=false)
    private Teacher teacher;

    @OneToMany(mappedBy="homework", fetch=FetchType.EAGER)
    private List<FileForHomework> filesForHomework;

    @OneToMany(mappedBy="homework", fetch=FetchType.EAGER)
    private List<FileForHomework> answers;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="groupId")
    private Group group;

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
