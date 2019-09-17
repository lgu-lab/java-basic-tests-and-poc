package org.demo.instrumentation;

public class Instrumentation {
	
	private Instrumentation() {}
	
	/**
	 * Code instrumentation activation
	 * This environment variable that must be defined with value = "true" 
	 * to activate the instrumentation 
	 */
	private static final String  ENVIRONMENT_VAR_NAME = "CODE_INSTRUM" ;
	private static final String  SYSTEM_PROPERTY_NAME = "code.instrum" ;

	private static boolean active = false ;
	private static boolean activeChecked = false ;

	public static final String getActivationEnvVarName() {
		return ENVIRONMENT_VAR_NAME ;
	}
	
	public static final boolean isActive() {
		if ( activeChecked ) {
			// Already checked
			return active ;
		}
		else {
			// Not yet checked
			
			// 1) Check ENVIR VARIABLE 
			String envValue = System.getenv(ENVIRONMENT_VAR_NAME);
			if ( "true".equalsIgnoreCase(envValue) ) {
				active = true ;
			}
			else {
				// 2) Check Java System Property
				String systemPropValue = System.getProperty(SYSTEM_PROPERTY_NAME);
				if ( "true".equalsIgnoreCase(systemPropValue) ) {
					active = true ;
				}
			}
			
			activeChecked = true ;
		}
		return active;
	}

}
