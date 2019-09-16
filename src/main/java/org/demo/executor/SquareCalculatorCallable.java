package org.demo.executor;

import java.util.concurrent.Callable;

public class SquareCalculatorCallable implements Callable<Integer> {

	private final int v ;
	private final long waitDuration ;
	
	public SquareCalculatorCallable(int v) {
		super();
		this.v = v;
		this.waitDuration = 1000 ;
	}

	public SquareCalculatorCallable(int v, long waitDuration) {
		super();
		this.v = v;
		this.waitDuration = waitDuration ;
	}


	@Override
	public Integer call() throws Exception {
		try {
			Thread.sleep(waitDuration);
		} catch (InterruptedException e) {
		}
		return v * v;
	}
	
}
