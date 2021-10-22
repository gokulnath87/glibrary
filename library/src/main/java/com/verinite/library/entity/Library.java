package com.verinite.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name ="libid")
    private int libid;
    @Column(name = "bookname")
    private String bookname;
    @Column(name ="issuername")
    private String issuername;
    @Column (name ="issueddate")
    private String issueddate;
    @Column (name ="returneddate")
    private String returneddate;

}


