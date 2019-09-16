package org.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class SquareCalculator {

	CompletableFuture<Integer> completableFuture ;
	
	public Future<Integer> calculate(int v) {
		int r = v * v;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		CompletableFuture<Integer> cf = new CompletableFuture<>();
		cf.complete(r);
		return cf ;

//		// In Java 8 it's possible to use the built-in 'CompletableFuture'
//		//
//		Future<Integer> result = CompletableFuture.completedFuture(r);
//		return result;
		
		
	}
	
	public Future<Integer> launchComputation(int v) {
		completableFuture = new CompletableFuture<>();
		return completableFuture;
	}
}
