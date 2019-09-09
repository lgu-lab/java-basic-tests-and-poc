package org.demo.perfmonitor.tooling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Time measures stored in a list
 * 
 * @author laguerin
 *
 */
public class TimeMeasures {

	private static final LinkedList<TimeMeasureItem> list = new LinkedList<>();

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
		list.add(new TimeMeasureItem(name, startTime, timeMeasured));
	}

	/**
	 * Returns a list containing all the measures registered
	 * 
	 * @return
	 */
	public static final LinkedList<TimeMeasureItem> getList() {
		return list;
	}

	/**
	 * Writes all the measures in the given file
	 * @param fileFullPath
	 * @return
	 */
	public static final boolean write(String fileFullPath) {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String now = sdfDate.format(new Date());
	    
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileFullPath));
			writer.write("Time measures ( " + now + " ) \n");
			for (TimeMeasureItem tm : list) {
				writer.write(" . " + tm + "\n");
			}
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
