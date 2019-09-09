package org.demo.java7.closeable.usage;

public class Service1 {

	public void doSomething(boolean ok) {
		if ( ok ) {
			System.out.println("Service works fine"); System.out.flush();
		}
		else {
			System.out.println("Argh, something gets wrong"); System.out.flush();
			throw new RuntimeException("My RuntimeException");
		}
	}

	public void doSomething2(boolean ok) throws Exception {
		if ( ok ) {
			System.out.println("Service works fine"); System.out.flush();
		}
		else {
			System.out.println("Error in service "); System.out.flush();
			throw new Exception("My Exception");
		}
	}
}
