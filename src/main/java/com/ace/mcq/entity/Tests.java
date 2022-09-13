package com.ace.mcq.entity;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Tests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id")
	private Integer testId;

	@Column(name = "name")
	private String name;

	@Column(name = "subject_id")
	private Integer subjectId;

	@Column(name = "crt")
	private Timestamp creatTimeStamp;

	@Column(name = "exp")
	private Timestamp expTimeStamp;
}
