package org.demo.instrudemo.counters;

import org.demo.instrumentation.counters.Counter;
import org.demo.instrumentation.counters.Counters;

public class Usage {

	public static void main(String[] args) {
		
		Counter c1 = Counters.getCounter("c1") ;
		Counter c2 = Counters.getCounter("c2") ;
		c1.increment();
		c1.increment();
		c2.increment();
		c2.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		
		Counter c1bis = Counters.getCounter("c1") ;
		c1bis.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
		c1.increment();
		c1.increment();
		System.out.println("c1 : " + c1);
		System.out.println("c1bis : " + c1bis);
	}
	
	
}
