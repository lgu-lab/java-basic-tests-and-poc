package org.demo.date.format;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatterDemo {
	
	public static void main(String[] args) {
		
		// NOT THREAD SAFE
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println("Formatted Date : " + sdf.format(new Date()) );
		
		// Since Java 8 
		// This class is immutable and thread-safe
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		System.out.println("Formatted LocalDate : " + dtf.format(LocalDate.now()) );
		
		
	}
}
