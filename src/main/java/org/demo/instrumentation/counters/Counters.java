package org.demo.instrumentation.counters;

import java.util.HashMap;
import java.util.Map;

public class Counters {
	
	private Counters() {}

	private static final Map<String, Counter> countersMap = new HashMap<>();
	
	public static Counter getCounter(String name) {
		Counter counter = countersMap.get(name);
		if ( counter == null ) {
			counter = new Counter(name);
			countersMap.put(name, counter);
		}
		return counter;
	}
}
