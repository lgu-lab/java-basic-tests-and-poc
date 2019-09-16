package org.demo.instrudemo.measures;

import java.util.concurrent.Callable;

import org.demo.instrumentation.measures.TimeMeasure;
import org.demo.instrumentation.measures.TimeMeasures;

public class CallableService implements Callable<Void> {

	private final MyService service = new MyService();
	private final long duration ;
	
	public CallableService(long duration) {
		super();
		this.duration = duration;
	}

	@Override
	public Void call() throws Exception {
		try ( TimeMeasure x = new TimeMeasure("service-call") ) {
		service.doSomethingEx(duration, true);
		}
		TimeMeasures.write("D:/TMP/measures-service-call");
		return null;
	}

}
