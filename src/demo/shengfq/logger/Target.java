package demo.shengfq.logger;

public class Target {
	Subject sub;
	public Target(Subject s){
		sub=s;
	}
	public void doTarget(){
		System.out.println("doTarget()");
		sub.doWork();
	}
}
