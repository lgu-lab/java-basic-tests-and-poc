package org.demo.perfmonitor.tooling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
	public static final List<TimeMeasureRecord> getList() {
		return list;
	}

	/**
	 * Writes all the measures in the given file name <br>
	 * The final file name will be the given path + current date + ".txt"
	 * @param fileFullPath file full path without extension ( e.g. "/tmp/myfile" )
	 * @return
	 */
	public static final boolean write(String fileFullPath) {
		Date dateNow = new Date();
		long threadId = Thread.currentThread().getId();
		String fullFileName = builFileName(fileFullPath, dateNow, threadId);
		try ( BufferedWriter writer = new BufferedWriter(new FileWriter(fullFileName)) ) {
			printAndClearList(writer, dateNow, threadId);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private static final synchronized void printAndClearList(BufferedWriter writer, Date date, long threadId) throws IOException {
		writer.write("Time measures ( " + formatDateHour(date) + " ) thread id : " + threadId + " \n");
		for (TimeMeasureRecord tm : list) {
			String startTime = "(start time " + formatDateHourMilisec(tm.getStartTime()) + ")" ;
			String s = "'" + tm.getName() + "' : " + tm.getTimeMeasured() + " ms " + startTime ;
			writer.write(" . " + s + "\n");
		}
		list.clear();
	}
	
	private static final String builFileName(String fileFullPath, Date date, long threadId) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
	    return fileFullPath + "_" + f.format(date) + "_T" + threadId + ".txt";
	}
	private static final String formatDateHourMilisec(long time) {
		Date date = new Date(time);
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return f.format(date);
	}
	private static final String formatDateHour(Date date) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return f.format(date);
	}
}
