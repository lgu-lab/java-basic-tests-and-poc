package org.demo.instrudemo.measures;

import java.util.List;

import org.demo.instrumentation.Instrumentation;
import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasureRecord;
import org.demo.instrumentation.measures.TimeMeasures;


public class MeasuresUsage1 {
	private static final boolean OK = true ;
	private static final boolean ERROR = false ;

	public static void main(String[] args) throws Exception {

		MyService service = new MyService();

		System.out.println("----------------------------");
		System.out.println("Instrumentation env var name = " + Instrumentation.getActivationEnvVarName());
		System.out.println("Is instrumentation active ? " + Instrumentation.isActive());
		System.out.println("Env var value : " + System.getenv(Instrumentation.getActivationEnvVarName()));
		System.out.println("----------------------------");
		try ( TimeMeasure x = new TimeMeasure("measure1") ) {
			System.out.println("start...");
			service.doSomethingEx(30, OK);
			System.out.println("stop.");
		}
		System.out.println("----------------------------");
		try ( TimeMeasure x = new TimeMeasure("measure2") ) {
			System.out.println("start...");
			service.doSomethingEx(65, OK);
			System.out.println("stop.");
		}
		System.out.println("----------------------------");
		try ( TimeMeasure x = new TimeMeasure("measure3") ) {
			System.out.println("start...");
			service.doSomethingEx(120, ERROR);
			System.out.println("stop.");
		}
		catch (Exception e) {
			System.out.println("Exception");
		}

		System.out.println("----------------------------");
		// 2 measures with the same name : not an error, just added in list, it will appear twice
		try ( TimeMeasure x = new TimeMeasure("measure2") ) { 
			System.out.println("start...");
			service.doSomethingEx(80, OK);
			System.out.println("stop.");
		}
		
		System.out.println("----------------------------");
		
		// Multiple try-with-resources
		try ( TimeMeasure x = new TimeMeasure("measure4") ; OtherResource res = new OtherResource() ) {
			System.out.println("start...");
			service.doSomethingEx(30, OK);
			res.hello();
			System.out.println("stop.");
		}
		
		//--------------------------------------------------------
		// REPORTING
		//--------------------------------------------------------
		System.out.println("Time Measure Reporting : " );
		List<TimeMeasureRecord> list = TimeMeasures.getList();
		for ( TimeMeasureRecord tm : list ) {
			System.out.println(" . " + tm );
		}
		
		//--------------------------------------------------------
		// WRITE TO FILE
		//--------------------------------------------------------
		TimeMeasures.write("D:/TMP/measures1");

		//--------------------------------------------------------
		// NEW SET OF MEASURES 
		//--------------------------------------------------------
		System.out.println("----------------------------");
		try ( TimeMeasure x = new TimeMeasure("measure3") ) {
			System.out.println("start...");
			service.doSomethingEx(120, ERROR);
			System.out.println("stop.");
		}
		catch (Exception e) {
			System.out.println("Exception");
		}

		//--------------------------------------------------------
		// WRITE TO FILE
		//--------------------------------------------------------
		TimeMeasures.write("D:/TMP/measures1-bis");
		TimeMeasures.write("D:/TMP/measures1-bis");
		TimeMeasures.write("D:/TMP/measures1-bis");

	}

}
 