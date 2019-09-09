package org.demo.perfmonitor.usage;

public class MyService {

	public void doSomethingRTEx(long duration, boolean ok) {
		if ( ok ) {
			sleep(duration);
			System.out.println("Service works fine"); System.out.flush();
		}
		else {
			sleep(duration/2);
			System.out.println("Argh, something gets wrong"); System.out.flush();
			throw new RuntimeException("My RuntimeException");
		}
	}

	public void doSomethingEx(long duration, boolean ok) throws Exception {
		if ( ok ) {
			sleep(duration);
			System.out.println("Service works fine"); System.out.flush();
		}
		else {
			sleep(duration/2);
			System.out.println("Error in service "); System.out.flush();
			throw new Exception("My Exception");
		}
	}
	
	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
}
