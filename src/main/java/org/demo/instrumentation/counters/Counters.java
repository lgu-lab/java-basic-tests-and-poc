package org.demo.instrumentation.counters;

import java.util.HashMap;
import java.util.Map;

public class Counters {

	private Counters() {}
	
	private static final ThreadLocal<Map<String, Counter>> countersMapHolder = new ThreadLocal<Map<String, Counter>>() {
		@Override
		protected Map<String, Counter> initialValue() {
			return new HashMap<>();
		}
	};
	
	/**
	 * Returns the counter associated with the given counter name<br>
	 * The counter is automatically created if it doesn't exist
	 * @param counterName
	 * @return
	 */
	public static Counter getCounter(String counterName) {
		Map<String, Counter> countersMap = countersMapHolder.get();
		Counter counter = countersMap.get(counterName);
		if ( counter == null ) {
			long threadId = Thread.currentThread().getId();
			counter = new Counter(counterName, 0L, threadId);
			countersMap.put(counterName, counter);
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
