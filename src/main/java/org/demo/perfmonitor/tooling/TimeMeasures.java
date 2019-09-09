package org.demo.perfmonitor.tooling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Time measures storage list
 * 
 * @author L Guerin
 *
 */
public class TimeMeasures {

	private static final LinkedList<TimeMeasureRecord> list = new LinkedList<>();

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
		list.add(new TimeMeasureRecord(name, startTime, timeMeasured));
	}

	/**
	 * Returns a list containing all the measures registered
	 * 
	 * @return
	 */
	public static final LinkedList<TimeMeasureRecord> getList() {
		return list;
	}

	/**
	 * Writes all the measures in the given file
	 * @param fileFullPath
	 * @return
	 */
	public static final boolean write(String fileFullPath) {
	    String now = formatDate(new Date());
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileFullPath));
			writer.write("Time measures ( " + now + " ) \n");
			for (TimeMeasureRecord tm : list) {
				String startTime = "(start time " + formatDate(tm.getStartTime()) + ")" ;
				String s = "'" + tm.getName() + "' : " + tm.getTimeMeasured() + " ms " + startTime ;
				writer.write(" . " + s + "\n");
			}
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	private static final String formatDate(long time) {
		Date date = new Date(time);
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return f.format(date);
	}
	private static final String formatDate(Date date) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return f.format(date);
	}
}
