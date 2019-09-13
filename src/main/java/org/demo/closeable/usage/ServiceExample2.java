package org.demo.closeable.usage;

import org.demo.closeable.tool.ServiceCallLogger;

public class ServiceExample2 {

	public static void main(String[] args) {

		Service1 service = new Service1();
		
		System.out.println("----------------------------");
		try ( ServiceCallLogger x = new ServiceCallLogger() ) {
			service.doSomething(true);
		}
		System.out.println("----------------------------");
	}

}
 