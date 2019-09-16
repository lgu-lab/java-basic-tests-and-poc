package org.demo.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Usage {

	public static void main(String[] args) throws Exception {

		/*
		 * If thread pool size is not enough the tasks are executed sequentially 
		 */
		//ExecutorService executor = Executors.newFixedThreadPool(1);
		ExecutorService executor = Executors.newFixedThreadPool(4);

		//-------------------------------------------------------------------------
		// Executor : submit / Runnable
		//-------------------------------------------------------------------------
		// Before Java 8 (new Runnable implementation)
		executor.submit(new Runnable() { // Thread #1 in pool
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					System.out.println("Runnable 1 step #" + i + " ...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Runnable 1 : InterruptedException.");
					}
				}
			}
		});

		// Since Java 8 : Lambda
		executor.submit(() -> { // Thread #2 in pool
			for (int i = 1; i < 20; i++) {
				System.out.println("Runnable 2 step #" + i + " ...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Runnable 2 : InterruptedException.");
				}
			}
		});

		// Since Java 8 : Lambda
		Future<?> future3 = executor.submit(() -> { // Thread #3 in pool
			for (int i = 1; i < 10; i++) {
				System.out.println("Runnable 3 step #" + i + " ...");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("Runnable 3 : InterruptedException.");
				}
			}
			System.out.println("Runnable 3 COMPLETED -----");
		});

		//-------------------------------------------------------------------------
		// Executor : submit / Callable
		//-------------------------------------------------------------------------
		Future<Integer> future4 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("I'm Callable task.");
                return 1 + 1;
            }
        });
		
		Future<Integer> future5 = executor.submit(new SquareCalculatorCallable(4));
		
		//-------------------------------------------------------------------------
		// Current main thread
		//-------------------------------------------------------------------------
//		System.out.println(" - future3.isDone() ? : " + future3.isDone());
		for (int i = 1; i < 10; i++) {
			System.out.println(" - Current thread step #" + i + " ...");
			System.out.println(" - future3.isDone() ? : " + future3.isDone());
			System.out.println(" - future4.isDone() ? : " + future4.isDone());
			System.out.println(" - future5.isDone() ? : " + future5.isDone());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				System.out.println(" - Current thread : InterruptedException.");
			}
		}
		System.out.println("===== END OF MAIN THREAD");
		System.out.println(" - future3.get() ? : " + future3.get());
		System.out.println(" - future4.get() ? : " + future4.get());
		System.out.println(" - future5.get() ? : " + future5.get());
	}
}
