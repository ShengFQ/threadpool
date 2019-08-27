package demo.shengfq.logger;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Subject {
	public void doWork(){
    	Logger.debug("call "+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    	System.out.println("dowork");
	}
}
