package org.demo.instrudemo.measures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasures;


public class MeasuresUsage4MultiThreads {

	public static void main(String[] args) throws Exception {

		System.out.println("Main thread - START");
		try ( TimeMeasure x = new TimeMeasure("main-thread") ) {
			ExecutorService executor = Executors.newFixedThreadPool(10);

			executor.submit(new CallableService(200)); 
			executor.submit(new CallableService(400)); 
			executor.submit(new CallableService(600)); 
			executor.submit(new CallableService(800)); 
			executor.submit(new CallableService(1000)); 
			executor.shutdown();
		}
		System.out.println("Main thread - END.");

		TimeMeasures.write("D:/TMP/measures-main-thread");
	}

}
 