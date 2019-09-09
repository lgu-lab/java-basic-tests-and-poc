package org.demo.java7.closeable.tool;

/**
 * AutoCloseable : A resource that must be closed when it is no longer needed.
 *    close method in AutoCloseable throws 'Exception'  
 *    ( instead of 'IOException' in AutoCloseable )
 *
 */
public class ServiceCallLogger implements ServiceCall {

	private boolean open = false ;
	
	public ServiceCallLogger() {
		super();
		this.open = true;
		beforeServiceCall() ;
	}

	public boolean isOpen() {
		return this.open ;
	}
	
	@Override
	public void close() {
		if ( this.open ) {
			afterServiceCall();
		}
		this.open = false;
	}
	
	//--------------------------------------------------------------------
	
	@Override
	public void beforeServiceCall() {
		System.out.println("beforeServiceCall()");
	}

	@Override
	public void afterServiceCall() {
		System.out.println("afterServiceCall()");
	}

}
