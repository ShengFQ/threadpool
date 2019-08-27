package demo.shengfq.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		testStringToDate();
	}
	private static void testStringToDate() {
        String s = "2017-05-25";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(date);
	}
}
