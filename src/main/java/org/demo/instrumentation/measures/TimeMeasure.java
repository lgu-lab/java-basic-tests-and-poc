package org.demo.instrumentation.measures;

/**
 * Time measure system based on AutoCloseable resource 
 * 
 * @author L Guerin
 *
 */
public class TimeMeasure implements AutoCloseable {

//	private final boolean isRoot;
//
//	private final String name;

	private final long startTime;
	
	private final TimeMeasureRecord record ;

//	private long timeMeasured = -1; // not yet measured

	/**
	 * Constructor (starts a new time measure) 
	 * @param name
	 * @param isRoot
	 */
	protected TimeMeasure(String name, boolean isRoot) {
		super();
//		this.name = name;
//		this.isRoot = isRoot;
		this.startTime = System.currentTimeMillis();

		// This is the 'root level' => clear the list before register 
		if ( isRoot ) {
			TimeMeasures.removeAll();
		}
		// Register this new measure (add a measure record in the list)
		this.record = TimeMeasures.register(name, startTime, -1L);
	}

	/**
	 * Constructor (starts a new time measure) 
	 * @param name
	 */
	public TimeMeasure(String name) {
		this(name, false);
	}
	
	
	@Override
	// close (end time measure) 
	// override 'close' without Exception propagation 
	public void close() { 
//		// Compute elapsed time 
//		long endTime = System.currentTimeMillis();
//		long timeMeasured = endTime - startTime;
//
//		// Record elapsed time
//		this.record.setTimeMeasured(timeMeasured);
//		
		this.record.endOfMeasure();
	}

}
