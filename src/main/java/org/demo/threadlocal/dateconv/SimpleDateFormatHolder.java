package org.demo.threadlocal.dateconv;

import java.text.SimpleDateFormat;

public class SimpleDateFormatHolder {
	
	private SimpleDateFormatHolder() {}
	
	private static final String FORMAT = "yyyy-MM-dd" ;
	
	private static final ThreadLocal<SimpleDateFormat> HOLDER = new ThreadLocal<SimpleDateFormat>() {
		
		// 'initialValue()' is called by 'ThreadLocal' class when a new instance is required 
		// (when a Thread initializes the instance for the first time)
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(FORMAT);
		}
	};

	public static SimpleDateFormat getInstance() {
		return HOLDER.get();
	}
}
