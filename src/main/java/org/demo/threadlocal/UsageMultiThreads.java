package org.demo.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsageMultiThreads {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);

		System.out.println("executor ready." );

		for ( int i = 1 ; i <= 10 ; i++ ) {
            System.out.println("Submit #" + i );
			//Future<Integer> future6 = 
			executor.submit(() -> {
				Whatever whatever = WhateverHolder.getInstance();
				whatever.increment();
	            System.out.println("whatever.getCount() : " + whatever.getCount() );
	            return whatever.getCount();
			});
		}
		executor.shutdown();
		System.out.println("END." );
	}
	
	
}
