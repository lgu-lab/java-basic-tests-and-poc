package org.demo.perfmonitor.usage;

public class OtherResource implements AutoCloseable {

	@Override
	// close (end time measure) 
	// override 'close' without Exception propagation 
	public void close() { 
		System.out.println("OtherResource - close()");
	}

	public void hello() { 
		System.out.println("OtherResource - hello()");
	}
}
