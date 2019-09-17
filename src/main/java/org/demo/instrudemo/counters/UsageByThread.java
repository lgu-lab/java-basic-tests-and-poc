package org.demo.instrudemo.counters;

import org.demo.instrumentation.counters.Counter;
import org.demo.instrumentation.counters.CountersGlobal;
import org.demo.instrumentation.counters.Counters;

public class UsageByThread {

	private static final String C200 = "C200" ;
	
	public static void main(String[] args) {
		
		Counter c1 = Counters.getCounter("c1") ;
		Counter c2 = Counters.getCounter("c2") ;
		c1.increment();
		c1.increment();
		c2.increment();
		c2.increment();
		Counters.increment(C200);
		Counters.increment(C200);
		Counters.increment(C200);
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c200 : " + Counters.getCounter(C200));
		
		Counters.reset(C200);
		Counters.increment(C200);
		Counter c1bis = CountersGlobal.getCounter("c1-global") ;
		c1bis.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		c1.increment();
		c1.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		System.out.println("c200 : " + Counters.getCounter(C200));
		
		System.out.println("-----" );
		System.out.println("REPORT / GLOBAL : " );
		CountersGlobal.write();
		System.out.println("-----" );
		System.out.println("REPORT / BY THREAD : " );
		Counters.write();
		Counters.write("D:/TMP/counters");

		
	}
	
	
}
