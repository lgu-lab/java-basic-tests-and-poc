package org.demo.java7.closeable.resources;

import org.demo.java7.closeable.interfaces.MyCloseable;

/**
 * AutoCloseable : A resource that must be closed when it is no longer needed.
 *    close method in AutoCloseable throws 'Exception'  
 *    ( instead of 'IOException' in AutoCloseable )
 *
 */
public class MyResource3 implements MyCloseable {

	private boolean open = false ;
	
	public MyResource3() {
		super();
		this.open = true;
		System.out.println("Constructor --> status = OPEN");
	}

	public boolean isOpen() {
		return this.open ;
	}
	
	@Override
	public void close() {
		this.open = false;
		System.out.println("close() --> status = CLOSED");
	}

}
