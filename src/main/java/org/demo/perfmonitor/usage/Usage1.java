package org.demo.perfmonitor.usage;

import java.util.List;

import org.demo.perfmonitor.tooling.TimeMeasure;
import org.demo.perfmonitor.tooling.TimeMeasureItem;
import org.demo.perfmonitor.tooling.TimeMeasures;


public class Usage1 {
	private static final boolean OK = true ;
	private static final boolean ERROR = false ;

	public static void main(String[] args) throws Exception {

		MyService service = new MyService();

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
		try ( TimeMeasure x = new TimeMeasure("measure1") ) {
			System.out.println("start...");
			service.doSomethingEx(30, ERROR);
			System.out.println("stop.");
		}
		catch (Exception e) {
			System.out.println("Exception");
		}
		
		System.out.println("----------------------------");
		
		// Multiple try-with-resources
		try ( TimeMeasure x = new TimeMeasure("measure1") ; OtherResource res = new OtherResource() ) {
			System.out.println("start...");
			service.doSomethingEx(30, OK);
			res.hello();
			System.out.println("stop.");
		}
		
		//--------------------------------------------------------
		// REPORTING
		//--------------------------------------------------------
		System.out.println("Time Measure Reporting : " );
		List<TimeMeasureItem> list = TimeMeasures.getList();
		for ( TimeMeasureItem tm : list ) {
			System.out.println(" . " + tm );
		}
		
		TimeMeasures.write("D:/TMP/measures.txt");
	}

}
 