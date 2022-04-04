package diary.entities;

import javax.persistence.*;

@Entity
@Table(name = "filesForAnswer")
public class FileForAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "URL")
    public String URL;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="answerId")
    private Answer answer;

}
