package org.demo.date.format.perf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasures;

public class TestDateFmtPerf {

	private static final int N = 1_000_000 ;
	private static final String FORMAT = "yyyy-MM-dd" ;

	
	public static void main(String[] args) {
		
		XMLGregorianCalendar xmlGC = createXMLGregorianCalendar();
		
		System.out.println("XMLGregorianCalendar : " + xmlGC);
		
		try ( TimeMeasure x = new TimeMeasure("Case 1") ) {
			System.out.println("Test 1");
			String s = "";
			for ( int i = 1 ; i <= N ; i++ ) {
				s = convert1(xmlGC);
			}
			System.out.println("Result : " + s);
		}
		try ( TimeMeasure x = new TimeMeasure("Case 2") ) {
			System.out.println("Test 2");
			String s = "";
			for ( int i = 1 ; i <= N ; i++ ) {
				s = convert2(xmlGC);
			}
			System.out.println("Result : " + s);
		}
		TimeMeasures.write();
	}
	
	public static XMLGregorianCalendar createXMLGregorianCalendar() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException("Cannot instanciate XMLGregorianCalendar", e);
		}
	}
	
	public static String convert1(XMLGregorianCalendar v) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		Date date = v.toGregorianCalendar().getTime();
		return sdf.format(date);
	}

	public static String convert2(XMLGregorianCalendar v) {
		return String.format("%04d-%02d-%02d", v.getYear(), v.getMonth(), v.getDay() );
	}
		
}
