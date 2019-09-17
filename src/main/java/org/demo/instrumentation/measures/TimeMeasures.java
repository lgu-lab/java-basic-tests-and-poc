package org.demo.instrumentation.measures;

import java.util.List;

import org.demo.instrumentation.Instrumentation;

/**
 * Time measures storage list
 * 
 * @author L Guerin
 *
 */
public class TimeMeasures {

	/**
	 * Maximum list size for measures storage
	 */
	private static final int MAX_LIST_SIZE = 2048 ;
	
	/**
	 * Private constructor
	 */
	private TimeMeasures() {
	}

	/**
	 * Registers the given measure
	 * 
	 * @param name
	 * @param startTime
	 * @param timeMeasured
	 */
	protected static final void register(String name, long startTime, long timeMeasured) {
		if ( ! Instrumentation.isActive() ) return;
		List<TimeMeasureRecord> list = TimeMeasuresHolder.getList();
		if ( list.size() >= MAX_LIST_SIZE ) {
			list.clear();
		}
		list.add(new TimeMeasureRecord(name, startTime, timeMeasured));
	}

	/**
	 * Returns a list containing all the measures registered
	 * 
	 * @return
	 */
	public static final List<TimeMeasureRecord> getList() {
		return TimeMeasuresHolder.getList();
	}

	/**
	 * Removes all the registered measures
	 */
	public static final void removeAll() {
		TimeMeasuresHolder.getList().clear();
	}

	/**
	 * Writes all the measures in the given file name <br>
	 * The final file name will be the given path + current date + ".txt"
	 * @param fileFullPath file full path without extension ( e.g. "/tmp/myfile" )
	 * @return
	 */
	public static final boolean write(String fileFullPath) {
		if ( ! Instrumentation.isActive() ) return false;
		List<TimeMeasureRecord> list = TimeMeasuresHolder.getList();
		TimeMeasuresWriter w = new TimeMeasuresWriter(list);
		boolean r = w.write(fileFullPath);
		list.clear();
		return r ;
	}
	
	/**
	 * Writes all the measures in the standard output (console) <br>
	 * @return
	 */
	public static final boolean write() {
		if ( ! Instrumentation.isActive() ) return false;
		List<TimeMeasureRecord> list = TimeMeasuresHolder.getList();
		TimeMeasuresWriter w = new TimeMeasuresWriter(list);
		boolean r = w.write();
		list.clear();
		return r ;
	}
	
}
