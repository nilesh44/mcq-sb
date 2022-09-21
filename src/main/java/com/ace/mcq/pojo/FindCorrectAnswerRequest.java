package com.ace.mcq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCorrectAnswerRequest {

	private  Integer questionId;
	private Integer optionId;
}
