package org.test.pdf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnterDate {
	
	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy年MM月dd日（EEE）").format(new Date());
	}

}
