package org.demo.instrumentation.counters;

import java.util.HashMap;
import java.util.Map;

public class CountersForCurrentThread {

	private CountersForCurrentThread() {}
	
	private static final ThreadLocal<Map<String, Counter>> countersMapHolder = new ThreadLocal<Map<String, Counter>>() {
		@Override
		protected Map<String, Counter> initialValue() {
			return new HashMap<>();
		}
	};
	
	/**
	 * Returns the counter associated with the given counter name<br>
	 * The counter is automatically created if it doesn't exist
	 * @param name
	 * @return
	 */
	public static Counter getCounter(String name) {
		Map<String, Counter> countersMap = countersMapHolder.get();
		Counter counter = countersMap.get(name);
		if ( counter == null ) {
			long threadId = Thread.currentThread().getId();
			counter = new Counter(name, 0L, threadId);
			countersMap.put(name, counter);
		}
		return counter;
	}
}
