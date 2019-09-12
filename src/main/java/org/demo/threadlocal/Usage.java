package org.demo.threadlocal;

public class Usage {

	public static void main(String[] args) {
		
		Whatever w11 = ThreadLocalObjects.getWhatever1();
		System.out.println("w11 count = " + w11.getCount());
		w11.increment();
		w11.increment();
		
		Whatever w12 = ThreadLocalObjects.getWhatever1();
		System.out.println("w12 count = " + w12.getCount());
		w12.increment();
		
		System.out.println("w11 count = " + w11.getCount());
		System.out.println("w12 count = " + w12.getCount());
	}
	
	
}
