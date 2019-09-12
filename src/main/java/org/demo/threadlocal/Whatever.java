package org.demo.threadlocal;

public class Whatever {

	private int count = 0;

	
	public Whatever() {
		super();
		System.out.println("Whatever constructor");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void increment() {
		count++;
	}
}
