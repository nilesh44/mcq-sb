package com.ace.mcq.entity;

import java.security.Timestamp;

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
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id")
	private Integer optionId;

	@Column(name = "option")
	private String option;

	@Column(name = "question_id")
	private Integer questionId;

	@Column(name = "isCorrect")
	private boolean isCorrect;

	@Column(name = "crt")
	private Timestamp creatTimeStamp;

	@Column(name = "exp")
	private Timestamp expTimeStamp;

}
