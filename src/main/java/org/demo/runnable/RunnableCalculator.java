package org.demo.runnable;

public class RunnableCalculator implements Runnable {

	private final int value;

	private int result = 0 ;
	
	
	public RunnableCalculator(int value) {
		super();
		this.value = value;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(value*100);
		} catch (InterruptedException e) {
		}
		result = value * value;
	}

	public int getResult() {
		return result ;
	}
}
