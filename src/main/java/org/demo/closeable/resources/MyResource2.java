package org.demo.closeable.resources;

/**
 * AutoCloseable : A resource that must be closed when it is no longer needed.
 *    close method in AutoCloseable throws 'Exception'  
 *    ( instead of 'IOException' in AutoCloseable )
 *
 */
public class MyResource2 implements AutoCloseable {

	private boolean open = false ;
	
	public MyResource2() {
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
