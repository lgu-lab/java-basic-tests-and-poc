package org.demo.instrumentation.measures;

/**
 * Time measure system based on AutoCloseable resource 
 * 
 * @author L Guerin
 *
 */
public class TimeMeasure implements AutoCloseable {

	private final String name;

	private final long startTime;

	private long timeMeasured = -1; // not yet measured

	/**
	 * Constructor (start time measure) 
	 * 
	 * @param name
	 */
	public TimeMeasure(String name) {
		super();
		this.name = name;
		this.startTime = System.currentTimeMillis();
	}

	@Override
	// close (end time measure) 
	// override 'close' without Exception propagation 
	public void close() { 
		// Compute elapsed time 
		long endTime = System.currentTimeMillis();
		this.timeMeasured = endTime - startTime;

		// Store elapsed time
		TimeMeasures.register(name, startTime, timeMeasured);
	}

	public long getTimeMeasured() {
		return this.timeMeasured;
	}
}
