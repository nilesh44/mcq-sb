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

@Table(name = "questions")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Integer questionId;

	@Column(name = "question")
	private String question;

	@Column(name = "test_id")
	private Integer testId;

	@Column(name = "crt")
	private Timestamp creatTimeStamp;

	@Column(name = "exp")
	private Timestamp expTimeStamp;

}
