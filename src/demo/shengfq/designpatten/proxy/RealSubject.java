package demo.shengfq.designpatten.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sheng on 18/6/3.
 */
public class RealSubject implements Subject,KSubject {

    @Override
    public void sayHello() {
        System.out.println("hello   "+this.hashCode());
    }

    @Override
    public void doWork() {
        System.out.println(" doWork: "+this.hashCode());
    }

    @Override
    public void kill() {
        System.out.println(" kill :"+this.hashCode());
    }
}
