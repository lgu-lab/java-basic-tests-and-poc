package org.demo.perfmonitor.tooling;

public class TimeMeasureItem {

	private final String name;

	private final long startTime;

	private final long timeMeasured ;

	/**
	 * Constructor
	 * @param name
	 * @param startTime
	 * @param timeMeasured
	 */
	public TimeMeasureItem(String name, long startTime, long timeMeasured) {
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
		//return "'" + name + " (startTime:" + startTime + ") : duration = " + timeMeasured + " ms";
		return "'" + name + "' : " + timeMeasured + " ms";
	}

}
