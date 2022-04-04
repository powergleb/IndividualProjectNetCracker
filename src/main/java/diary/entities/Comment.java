package diary.entities;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
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

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="answerId")
    private Answer answer;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="userId")
    private User user;




}
