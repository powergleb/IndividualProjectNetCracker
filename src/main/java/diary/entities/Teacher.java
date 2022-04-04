package diary.entities;


import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends User
{
    @OneToMany(mappedBy="homeworks", fetch=FetchType.EAGER)
    private List<Homework> homeworks;

    public Teacher(String name, String secondName, String patronymic, String pass, String login, String phone, String address, String mail, List<Homework> homeworks) {
        super(name, secondName, patronymic, pass, login, phone, address, mail);
        this.homeworks = homeworks;
    }

    public Teacher(List<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    public void setValue(Class<?> type,
                         Teacher teacher,
                         String paramName,
                         String value) throws Exception {

        Field field;
        field = Teacher.class.getField(paramName);

        if (field == null)
            throw new IllegalArgumentException(
                    "can't find the field with name: " + paramName);

        field.setAccessible(true);
        field.set(teacher, value);
    }
}