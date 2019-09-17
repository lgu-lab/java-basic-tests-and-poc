package org.demo.instrudemo.counters;

import org.demo.instrumentation.counters.Counter;
import org.demo.instrumentation.counters.CountersGlobal;

public class UsageGlobal {

	public static void main(String[] args) {
		
		Counter c1 = CountersGlobal.getCounter("c1") ;
		c1.increment();
		c1.increment(3);
		CountersGlobal.increment("c1");
		
		Counter c2 = CountersGlobal.getCounter("c2") ;
		c2.increment();
		c2.increment();
		CountersGlobal.increment("c2");

		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		
		System.out.println("----- RESET 'c1' " );

		CountersGlobal.reset("c1");
		Counter c1bis = CountersGlobal.getCounter("c1") ;
		c1bis.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		c1.increment();
		c1.increment();
		c1.increment(100);
		c2.setValue(1234);
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		
		System.out.println("-----" );
		System.out.println("REPORT : " );
		CountersGlobal.write();
		CountersGlobal.write("D:/TMP/counters-global");
		
		System.out.println("----- REMOVE ALL " );
		CountersGlobal.removeAll();
		System.out.println("-----" );
		System.out.println("REPORT : " );
		CountersGlobal.write();
	}
	
	
}
