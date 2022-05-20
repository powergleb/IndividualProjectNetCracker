package com.diary.DiaryProject.entities;

import com.diary.DiaryProject.entities.intefaces.FileContainer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "filesInfo")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private Long size;

    @Column(name = "key")
    private String key;

    @Column(name = "uploadDate")
    private LocalDate uploadDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fileContainerId", referencedColumnName = "id")
    private FileContainer fileContainer;
}