package Java_Examples.dateFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateInRequiredFormat {

	public static void main(String[] args) {
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatter.format(date1));

		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yy");
		System.out.println(formatter1.format(date1));
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		System.out.println(formatter2.format(date1));
	}
}
