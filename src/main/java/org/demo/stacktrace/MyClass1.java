package org.demo.stacktrace;

public class MyClass1 {


	public static void doSomething() throws Exception {
		function2();
	}

	private static void function2() throws Exception {
		try {
			function3();
		} catch (Exception e) {
			throw new Exception("My Exception", e);
		}
	}

	private static void function3() {
		function4();
	}

	private static void function4() {
		throw new IllegalArgumentException("Invalid argument");
	}

}
