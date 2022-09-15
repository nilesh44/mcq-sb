package com.ace.mcq.utilities;

import java.sql.Timestamp;
import com.ace.mcq.execption.RecordNotFoundException;

public class CommonUitilities {
	
	
	public static Timestamp getSqlTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static <T> void checkRecordNotFound(T t, String message){
		
		if(t==null) {
			 throw new RecordNotFoundException(message);
		}
	}

}
