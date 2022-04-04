package diary.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "numberOfGroup")
    public int numberOfGroup;

    @OneToMany(mappedBy="group", fetch=FetchType.EAGER)
    private List<Student> students;
    

}
