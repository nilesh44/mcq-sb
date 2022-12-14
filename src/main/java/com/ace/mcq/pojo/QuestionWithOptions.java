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
public class QuestionWithOptions {
	private String questionId;
	private String question;

	private List<OptionResonse> options;

	
}
