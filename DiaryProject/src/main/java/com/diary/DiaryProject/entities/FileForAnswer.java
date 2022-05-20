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
//@Table(name = "filesForAnswer")
//public class FileForAnswer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    public int id;
//
//    @Column(name = "URL")
//    public String URL;
//
//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "answerId")
//    private Answer answer;
//
//}
