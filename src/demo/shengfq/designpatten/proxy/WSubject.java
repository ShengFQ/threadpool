package demo.shengfq.designpatten.proxy;

/**
 * Created by sheng on 18/6/3.
 */
public class WSubject implements Subject{
    @Override
    public void sayHello() {
        System.out.println(" sayhello: "+this.hashCode());
    }

    @Override
    public void doWork() {
        System.out.println(" doWork: "+this.hashCode());
    }
}
