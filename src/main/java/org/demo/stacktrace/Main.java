package org.demo.stacktrace;

public class Main {

	public static void main(String[] args) {
		try {
			function1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			String stackTrace = getStackTrace(e) ;
//			System.out.println("--- Stack trace as String : ");
//			System.out.println(getStackTrace(e));
			System.out.println("--- Full Stack trace as String : ");
			System.out.println(StackTraceUtil.getFullStackTrace(e));
		}
	}

	private static void function1() throws Exception {
		function2();
	}

	private static void function2() throws Exception {
		try {
			function3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("My Exception", e);
		}

	}

	private static void function3() {
		function4();
	}

	private static void function4() {
		throw new RuntimeException("My RuntimeException");
	}

//	private static String getStackTrace(Exception e) {
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//		e.printStackTrace(pw);
//		StackTraceElement[] elements = e.getStackTrace();
//		return sw.toString(); // stack trace as a string
//	}
}
