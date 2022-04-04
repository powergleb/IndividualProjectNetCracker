package diary.entities;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
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

}
