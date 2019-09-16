package org.demo.instrudemo.counters;

import org.demo.instrumentation.counters.Counter;
import org.demo.instrumentation.counters.CountersGlobal;

public class UsageGlobal {

	public static void main(String[] args) {
		
		Counter c1 = CountersGlobal.getCounter("c1") ;
		Counter c2 = CountersGlobal.getCounter("c2") ;
		c1.increment();
		c1.increment();
		c2.increment();
		c2.increment();
		CountersGlobal.increment("c2");
		CountersGlobal.increment("c1");
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		
		System.out.println("-----" );

		CountersGlobal.reset("c1");
		Counter c1bis = CountersGlobal.getCounter("c1") ;
		c1bis.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		c1.increment();
		c1.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
	}
	
	
}
