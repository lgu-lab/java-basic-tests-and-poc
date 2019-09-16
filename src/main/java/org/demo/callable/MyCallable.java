package org.demo.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

	
	/*
	 * Callable is a '@FunctionalInterface'
	 * The method defined in this interface is 'call'
	 * 
	 * public interface Callable<V> {
	 *   V call() throws Exception;
	 * }
	 */
	
	private int count = 0 ;
	
	// 
	@Override
	public Integer call() throws Exception {
		count++;
		return count;
	}

}
