package org.demo.threadlocal.dateconv;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class DatatypeFactoryHolder {
	
	private DatatypeFactoryHolder() {}

	private static final ThreadLocal<DatatypeFactory> HOLDER = new ThreadLocal<DatatypeFactory>() {
		
		// 'initialValue()' is called by 'ThreadLocal' class when a new instance is required 
		// (when a Thread initializes the instance for the first time)
		@Override
		protected DatatypeFactory initialValue() {
			try {
				return DatatypeFactory.newInstance();
			} catch (DatatypeConfigurationException e) {
				throw new IllegalStateException("Cannot create DatatypeFactory", e);
			}
		}
	};
	
	public static DatatypeFactory getInstance() {
		return HOLDER.get();
	}
}
