package org.demo.instrumentation.counters;

public class Counter {

	private final String name ;
	private final long   threadId;
	private long count = 0 ;
	
	public Counter(String name) {
		super();
		this.name = name;
		this.count = 0L;
		this.threadId = 0L;
	}
	
	public Counter(String name, long count) {
		super();
		this.name = name;
		this.count = count;
		this.threadId = 0L;
	}

	public Counter(String name, long count, long threadId) {
		super();
		this.name = name;
		this.count = count;
		this.threadId = threadId;
	}

	public void increment() {
		count++;
	}
	
	public String getName() {
		return name;
	}
	
	public long getThreadId() {
		return threadId;
	}
	
	public long getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Counter '" + name + "' (" + threadId + ") = " + count;
	}
	
}
