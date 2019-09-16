package org.demo.future;

import java.util.concurrent.Future;

public class Usage {

	public static void main(String[] args) throws Exception {
		
		SquareCalculator calculator = new SquareCalculator();
		
		Future<Integer> r = calculator.calculate(4); // Nonsens to call it without Executor (wait for return)
		
		System.out.println("r.isDone()  : " + r.isDone() );
		System.out.println("r.get()  : " + r.get() );
		System.out.println("r.isDone()  : " + r.isDone() );
	}

}
