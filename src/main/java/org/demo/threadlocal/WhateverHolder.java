package org.demo.threadlocal;

public class WhateverHolder {
	
	private static final ThreadLocal<Whatever> HOLDER = new ThreadLocal<Whatever>() {
		
		// 'initialValue()' is called by 'ThreadLocal' class when a new instance is required 
		// (when a Thread initializes the instance for the first time)
		@Override
		protected Whatever initialValue() {
			return new Whatever();
		}
	};

	public static Whatever getInstance() {
		return HOLDER.get();
	}
}
