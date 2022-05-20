package com.diary.DiaryProject.entities.intefaces;

import com.diary.DiaryProject.entities.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FileContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "taskText")
    @NotEmpty( message = "описание не может быть пустым")
    private String taskText;

    @Column(name = "date")
    private GregorianCalendar date;

    @OneToMany(mappedBy = "fileContainer")
    private List<FileInfo> fileInfoList;


}
