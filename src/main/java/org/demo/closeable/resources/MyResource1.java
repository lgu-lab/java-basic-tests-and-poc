package org.demo.closeable.resources;

import java.io.Closeable;
import java.io.IOException;

/**
 * Info : 
 *   Closeable extends AutoCloseable 
 *   close method in Closeable throws 'IOException' (not generic, specialized for IO resources)
 *
 */
public class MyResource1 implements Closeable {

	private boolean open = false ;
	
	public MyResource1() {
		super();
		this.open = true;
		System.out.println("Constructor --> status = OPEN");
	}

	public boolean isOpen() {
		return this.open ;
	}
	
	@Override
	public void close() throws IOException {
		this.open = false;
		System.out.println("close() --> status = CLOSED");
	}
}
