package org.demo.perfmonitor.usage;

import org.demo.perfmonitor.tooling.TimeMeasures;


public class Usage2 {

	public static void main(String[] args) throws Exception {

		System.out.println("Noting : no measure.");
		// Side effect test
		TimeMeasures.write("D:/TMP/measures2.txt");
	}

}
 