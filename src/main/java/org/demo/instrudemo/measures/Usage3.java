package org.demo.instrudemo.measures;

import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasures;


public class Usage3 {

	public static void main(String[] args) throws Exception {

		
		MyService service = new MyService();
		
		TimeMeasure tm ;
		
		tm = new TimeMeasure("m1") ;
		System.out.println("start...");
		service.doSomethingEx(30, true);
		System.out.println("stop.");
		tm.close();
		
		tm = new TimeMeasure("m2") ;
		System.out.println("start...");
		service.doSomethingEx(520, true);
		System.out.println("stop.");
		tm.close();
		
		TimeMeasures.write("D:/TMP/measures3");
	}

}
 