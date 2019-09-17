package org.demo.instrudemo.measures;

import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasureRoot;


public class MeasuresUsage5Root {

	public static void main(String[] args) throws Exception {

		
		try ( TimeMeasure x = new TimeMeasureRoot("m1-root", "D:/TMP/measures-root") ) {
			System.out.println("main start...");
			for ( int i = 0 ; i < 3 ; i++) {
				Thread.sleep(10);
				func1(i);
			}
			System.out.println("main stop.");
		}
	}
	
	public static void func1(int x) throws Exception {
		try ( TimeMeasure m = new TimeMeasure("func1") ) {
			System.out.println("func1 start...");
			for ( int i = 0 ; i < 5 ; i++) {
				Thread.sleep(30);
				func2(i);
			}
			System.out.println("func1 stop.");
		}
	}

	public static void func2(int x) throws Exception {
		try ( TimeMeasure m = new TimeMeasure("func2") ) {
			System.out.println("func2 start...");
			Thread.sleep(15);
			System.out.println("func2 stop.");
		}
	}
}
 