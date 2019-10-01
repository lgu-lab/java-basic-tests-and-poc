package org.demo.instrudemo.counters;

import org.demo.instrumentation.Instrumentation;
import org.demo.instrumentation.counters.Counters;

public class CountersUsage3ByThread {

	private static final String MY_COUNTER_0 = "MY_COUNTER_0" ;
	private static final String MY_COUNTER_1 = "MY_COUNTER_1" ;
	private static final String MY_COUNTER_2 = "MY_COUNTER_2" ;
	
	public static void main(String[] args) {
		
		System.out.println("Instrumentation active ? " +  Instrumentation.isActive() );
		System.out.println("Instrumentation env variable name : " + Instrumentation.getActivationEnvVarName() );
		System.out.println("Instrumentation sys property name : " + Instrumentation.getSystemPropertyName() );
		
		Instrumentation.forceActivation();
		System.out.println("Instrumentation active ? " +  Instrumentation.isActive() );
		
		Counters.removeAll();
		
		process();
		System.out.println("MY_COUNTER_0 : " +  Counters.getCounter(MY_COUNTER_0) );
		System.out.println("MY_COUNTER_1 : " +  Counters.getCounter(MY_COUNTER_1) );
		System.out.println("MY_COUNTER_2 : " +  Counters.getCounter(MY_COUNTER_2) );
		
		
		System.out.println("REPORT / BY THREAD : " );
		Counters.write();
		Counters.write("D:/TMP/my-counters");

	}
	
	public static void process() {
		System.out.println("process() " );
		Counters.increment(MY_COUNTER_0);
		System.out.println("process() : calling myFunc1... " );
		for ( int i = 0 ; i < 35 ; i++ ) {
			myFunc1();
		}
		System.out.println("process() : calling myFunc2... " );
		for ( int i = 0 ; i < 120 ; i++ ) {
			myFunc2();
		}
		System.out.println("process() : end" );
	}	

	public static void myFunc1() {		
		Counters.increment(MY_COUNTER_1);
	}
	
	public static void myFunc2() {
		Counters.increment(MY_COUNTER_2);
	}	
}
