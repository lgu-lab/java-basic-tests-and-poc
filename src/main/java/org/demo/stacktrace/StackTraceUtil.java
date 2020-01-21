package org.demo.stacktrace;

public class StackTraceUtil {
	
	private StackTraceUtil() {
	}
	
	/**
	 * Return all the stack trace in a string
	 * @param exception
	 * @return
	 */
	public static String getFullStackTrace(Throwable exception) {
		StringBuilder sb = new StringBuilder();
		append(sb, "Exception", exception);
		return sb.toString(); // stack trace as a string
	}

	private static void append(StringBuilder sb, String type, Throwable exception) {
		sb.append(type );
		sb.append(" : " + exception.getClass().getCanonicalName() );
		sb.append(" : ");
		sb.append("'" + exception.getMessage() + "'");
		sb.append("\n");
		StackTraceElement[] elements = exception.getStackTrace();
		for ( StackTraceElement e : elements ) {
			sb.append(" . ");
			sb.append(e.getClassName());
			sb.append(" -> ");
			sb.append(e.getMethodName());
			sb.append(" [");
			sb.append(e.getLineNumber());
			sb.append("]\n");
		}
		if ( exception.getCause() != null ) {
			append(sb, "Cause", exception.getCause() );
		}
	}

}
