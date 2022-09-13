package com.ace.mcq.pojo;

import java.security.Timestamp;

import com.ace.mcq.entity.Tests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
	
	private String msg;

}
