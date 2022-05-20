//package com.diary.DiaryProject.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "filesForHomework")
//public class FileForHomework {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    public int id;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "fileInfoId", referencedColumnName = "id")
//    public FileInfo fileInfo;
//
//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "homeworkId")
//    private Homework homework;
//
//}

