package com.ace.mcq.validation;

import com.ace.mcq.execption.RecordAlradyPresentException;
import com.ace.mcq.execption.RecordNotFoundException;

public class CommonValidation {
	
public static <T> void checkRecordNotFound(T t, String message){
		
		if(t==null) {
			 throw new RecordNotFoundException(message);
		}
	}

public static <T> void checkRecordAlreadyPresent(T t, String message){
	
	if(t!=null) {
		 throw new RecordAlradyPresentException(message);
	}
}

}
