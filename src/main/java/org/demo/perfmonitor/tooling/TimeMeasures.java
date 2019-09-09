package org.demo.perfmonitor.tooling;

import java.util.LinkedList;

public class TimeMeasures {

	private static final LinkedList<TimeMeasureItem> list = new LinkedList<>();
	
	private TimeMeasures() {
	}
	
	public static final void register(String name, long startTime, long timeMeasured) {
		list.add( new TimeMeasureItem( name,  startTime,  timeMeasured) );
	}

	public static final LinkedList<TimeMeasureItem> getList() {
		return list ;
	}
	
}
