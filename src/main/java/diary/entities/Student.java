package diary.entities;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;


@Entity
@Table(name = "students")
public class Student extends User{

    @Column(name = "group")
    @ManyToOne
    @JoinColumn(name = "groupId")
    Group group;

    @OneToMany(mappedBy="answer", fetch=FetchType.EAGER)
    private List<Answer> answers;

    public Student(String name, String secondName, String patronymic, String pass, String login, String phone, String address, String mail, Group group) {
        super(name, secondName, patronymic, pass, login, phone, address, mail);
        this.group = group;
    }

    public void setValue(Class<?> type,
                         Student student,
                         String paramName,
                         String value) throws Exception {

        Field field;
        field = Teacher.class.getField(paramName);

        if (field == null)
            throw new IllegalArgumentException(
                    "can't find the field with name: " + paramName);

        field.setAccessible(true);
        field.set(student, value);
    }


}
