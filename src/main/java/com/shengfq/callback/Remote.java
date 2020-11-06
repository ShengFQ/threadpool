package com.shengfq.callback;
/**
 * 远程方法
 * */
public class Remote {
	public void executeMessage(String msg,final CallBack callBack){
		for(int i=0;i < 1000;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("remote excute msg:"+msg);
		msg = msg+" change...";
		callBack.execute(msg);
	}
}