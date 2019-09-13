package org.demo.instrumentation.measures;

/**
 * Time measure record   
 * 
 * @author L Guerin
 *
 */
public class TimeMeasureRecord {

	private final String name;

	private final long startTime;

	private final long timeMeasured ;

	/**
	 * Constructor
	 * @param name
	 * @param startTime
	 * @param timeMeasured
	 */
	public TimeMeasureRecord(String name, long startTime, long timeMeasured) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.timeMeasured = timeMeasured;
	}

	public String getName() {
		return name;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getTimeMeasured() {
		return timeMeasured;
	}

	@Override
	public String toString() {
		return "'" + name + "' : " + timeMeasured + " ms";
	}

}
