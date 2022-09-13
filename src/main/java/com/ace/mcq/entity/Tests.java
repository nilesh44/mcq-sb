package com.ace.mcq.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
