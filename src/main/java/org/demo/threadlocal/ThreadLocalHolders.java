package org.demo.threadlocal;

public class ThreadLocalHolders {

	//-------------------------------------------------------------------------------
	// ThreadLocal : old form 
	//-------------------------------------------------------------------------------
	private static final ThreadLocal<Whatever> whatever1Holder = new ThreadLocal<>() ;
	static {
		whatever1Holder.set(new Whatever()); // Initial value
	}
	public static final Whatever getWhatever1() {
		return whatever1Holder.get();
	}

	//-------------------------------------------------------------------------------
	// ThreadLocal : old form 
	//-------------------------------------------------------------------------------
	private static final ThreadLocal<Whatever> whatever2Holder = new ThreadLocal<>() ; // No initial value
	public static final Whatever getWhatever2() {
		Whatever whatever =  whatever2Holder.get();
		if(whatever == null) {
			// Not yet initialized 
			whatever = new Whatever();
			whatever2Holder.set(whatever); // Sets the current thread's copy of this thread-local variable to the specified value.
		}
		return whatever;
	}

	//-------------------------------------------------------------------------------
	// ThreadLocal : form Java 6 with 'initialValue()'
	//-------------------------------------------------------------------------------
	private static final ThreadLocal<Whatever> whatever3Holder = new ThreadLocal<Whatever>() {
		@Override
		protected Whatever initialValue() {
			return new Whatever();
		}
	};
	
	public static final Whatever getWhatever3() {
		return whatever3Holder.get();
	}
	
	//-------------------------------------------------------------------------------
	// ThreadLocal : form Java 8
	//-------------------------------------------------------------------------------
	private static final ThreadLocal<Whatever> whatever4Holder = ThreadLocal.withInitial(Whatever::new); 
	// ThreadLocal.withInitial() uses the Supplier<T> functional interface
	
	public static final Whatever getWhatever4() {
		return whatever4Holder.get();
	}
	
}
