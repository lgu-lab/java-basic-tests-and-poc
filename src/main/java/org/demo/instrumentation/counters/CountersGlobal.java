package org.demo.instrumentation.counters;

import java.util.HashMap;
import java.util.Map;

public class CountersGlobal {
	
	private CountersGlobal() {}

	private static final Map<String, Counter> countersMap = new HashMap<>();
	
	/**
	 * Returns the counter associated with the given counter name<br>
	 * The counter is automatically created if it doesn't exist
	 * @param name
	 * @return
	 */
	public static Counter getCounter(String name) {
		Counter counter = countersMap.get(name);
		if ( counter == null ) {
			counter = new Counter(name);
			countersMap.put(name, counter);
		}
		return counter;
	}
	
	/**
	 * Increments the counter identified by the given counter name
	 * @param counterName
	 */
	public static void increment(String counterName) {
		getCounter(counterName).increment();
	}

	/**
	 * Resets the counter identified by the given counter name
	 * @param counterName
	 */
	public static void reset(String counterName) {
		getCounter(counterName).reset();
	}
	
}
