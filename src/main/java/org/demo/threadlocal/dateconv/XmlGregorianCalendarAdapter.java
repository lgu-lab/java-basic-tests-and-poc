package org.demo.threadlocal.dateconv;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianCalendarAdapter extends XmlAdapter<String, XMLGregorianCalendar> {

	// marshal : 'POJO' XMLGregorianCalendar --> 'XML flow' String
	@Override
	public String marshal(XMLGregorianCalendar v) throws Exception {
		return marshalWithSimpleDateFormat(v);
	}

	protected String marshalWithSimpleDateFormat(XMLGregorianCalendar v) {
		Date date = v.toGregorianCalendar().getTime();
		// NB : SimpleDateFormat is not Thread Safe !!! => use ThreadLocal Holder
		return SimpleDateFormatHolder.getInstance().format(date);
	}

	protected String marshalOptimalPerformance(XMLGregorianCalendar v) {
		// twice as fast !
		return String.format("%04d-%02d-%02d", v.getYear(), v.getMonth(), v.getDay() );
	}

	// marshal : 'XML flow' String --> 'POJO' XMLGregorianCalendar 
	@Override
	public XMLGregorianCalendar unmarshal(String v) throws Exception {
		// NB : DatatypeFactory is probably not Thread Safe !!! => use ThreadLocal Holder
		return DatatypeFactoryHolder.getInstance().newXMLGregorianCalendar(v);
	}

}
