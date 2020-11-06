package com.shengfq.wujun;
/**
*多线程扫描文件夹内的子文件夹和文件,打印文件名称,统计文件数量
*
**/

import java.io.File;
import java.util.Vector;
public class ScannerFolder{
	private static int count;//文件数量
	private String filePath="/Users/sheng/Pictures";
	//文件数自增,多线程操作为了避免数据污染
	public   void countAdd(){//synchronized 写在方法头和方法体内的区别
		synchronized(ScannerFolder.class){
			count++;
		}
	}
	public void start(){
		//启动扫描线程
		WorkThread t=new WorkThread(filePath);
		t.start();
		System.out.println("开始扫描");
		while(!t.isCompleted()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException ex){

			}
		}
	}
	//监控器
	public static void main(String[] args){
		ScannerFolder scanner=new ScannerFolder();
		scanner.start();
		System.out.println("所有电子狗搜索完毕,扫描文件个数:"+count);
	}
	//执行器
	class WorkThread extends Thread{
		private String path;
		private boolean runned=false;//线程释放标志
		public Vector<WorkThread> threads=new Vector<WorkThread>();//线程安全的集合,所以不需要锁保护
		public WorkThread(String tempPath){
			this.path=tempPath;
		}
		public void run(){
			File file=new File(path);
			//如果路径为空,直接返回
			if(file==null ||"".equals(path)){
				runned=true;
				return;
			}
			//如果是文件,则执行++
			if(file.isFile()){
				countAdd();
				System.out.println("当前文件:"+file.getPath());
				runned=true;
				return;
			}
			//如果是文件夹,则新建线程执行扫描
			else{//add
				System.out.println("当前目录:"+path);
				File[] files=file.listFiles();
				for(File myfile:files){
					//if(myfile.isDirectory()){
						WorkThread t=new WorkThread(myfile.getPath());
						threads.add(t);
						t.start();

					//}
				}
			}
			runned=true;			
		}

		public boolean isCompleted(){
			boolean flag=true;
			if(!runned){
				return !flag;
			}
			for(WorkThread t:threads){
				if(!t.isCompleted()){
					flag=false;
					break;
				}
			}
			return flag;
		}
	}
}