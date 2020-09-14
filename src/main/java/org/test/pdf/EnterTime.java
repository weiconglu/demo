package org.test.pdf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnterTime {
	
	@Override
	public String toString() {
		return new SimpleDateFormat("HH時mm分").format(new Date());
	}

}
