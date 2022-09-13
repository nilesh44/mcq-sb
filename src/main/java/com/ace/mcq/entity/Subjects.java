package com.ace.mcq.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;

@Entity
@Table(name = "subject")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Integer subjectId;

	@Column(name = "name")
	private String name;

	@Column(name = "crt")
	private Timestamp creatTimeStamp;

	@Column(name = "exp")
	private Timestamp expTimeStamp;

}
