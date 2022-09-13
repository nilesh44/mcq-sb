package com.ace.mcq.entity;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="question")
@Entity
public class Questions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question")
    private String question;

    @Column(name="test_id")
    private Integer testid;

    @Column(name="crt")
    private Timestamp creatTimeStamp;

    @Column(name="exp")
    private Timestamp expTimeStamp;

    
}
