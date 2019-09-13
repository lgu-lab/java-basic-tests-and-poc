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
	
//	public static final Map<String, Counter> countersMap() {
//		return countersMapHolder.get();
//	}

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
