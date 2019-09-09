package org.demo.perfmonitor.usage;

import org.demo.perfmonitor.tooling.TimeMeasures;


public class Usage2 {

	public static void main(String[] args) throws Exception {

		// Side effect test
		TimeMeasures.write("D:/TMP/measures2.txt");
	}

}
 