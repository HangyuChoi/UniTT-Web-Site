package board;

import java.text.DecimalFormat;
import java.util.*;

public class MyCalendar {
	private String delimiter = "/";
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	public String getToday() {
		GregorianCalendar calendar = new GregorianCalendar();
		StringBuffer today = new StringBuffer();
		DecimalFormat df = new DecimalFormat("00");
		today.append(calendar.get(Calendar.YEAR));
		today.append(this.delimiter);
		today.append(df.format(calendar.get(Calendar.MONTH) + 1 ));
		today.append(this.delimiter);
		today.append(df.format(calendar.get(Calendar.DATE)));
		return today.toString();
	}
}
