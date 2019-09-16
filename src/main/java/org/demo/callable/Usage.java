package org.demo.callable;

import java.util.concurrent.Callable;

public class Usage {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Using a 'Callable' implemantation
		 */
		MyCallable task = new MyCallable() ;
		
		int i ;
		i = task.call();
		i = task.call();
		System.out.println("i = " + i);
		
		
		/*
		 * Using a 'Callable' defined with a 'Lambda'
		 */
		Callable<String> callable = () -> {
		    // Perform some computation
		    Thread.sleep(200);
		    return "My result";
		};
		System.out.println("callable.call() : " + callable.call());
	}
	
	
}
