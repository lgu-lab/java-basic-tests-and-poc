package org.demo.instrudemo.measures;

import org.demo.instrumentation.measures.TimeMeasures;


public class Usage2 {

	public static void main(String[] args) throws Exception {

		System.out.println("Noting : no measure.");
		// Side effect test
		TimeMeasures.write("D:/TMP/measures2");
	}

}
 