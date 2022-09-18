package com.ace.mcq.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWithOptionsCreate {
	
	private String question;
	
	private List<Option> options;
	
	private String testName;
	
	private String subjectName;

}
