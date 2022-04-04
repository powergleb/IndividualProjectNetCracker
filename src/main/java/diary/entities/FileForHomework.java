package diary.entities;

import javax.persistence.*;
@Entity
@Table(name = "filesForHomework")
public class FileForHomework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;

    @Column(name = "URL")
    public String URL;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="homeworkId")
    private Homework homework;

}

