package com.shengfq.wujun;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * 统计文件目录下的文件数量并统计运行时间
 * @author wujun
 *总文件数: 3511 统计耗时: 2243 毫秒
 */
public class App {
	
	private static Integer fileSum = new Integer(0);    //文件数量
	private static String rootDir = "/Users/sheng/schedule/target&plan&schedule&task/1万科移动需求开发计划[关闭]";    //根目录
	

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		App app = new App();
		app.start();
		long total = System.currentTimeMillis() - startTime;
		System.err.println("总文件数: " + fileSum + " 统计耗时: " + total + " 毫秒");
	}
	
	public void start() {
		ThreadFile tf = new ThreadFile(rootDir);
		tf.start();
		while(!tf.isComplete()) {
			//无限循环判断是否完成 TODO 为什么要在主UI线程上进行sleep?
			try {
				//稍微停顿下,(FIXME 理论上不应该加这个延迟)要不测试cpu扛不住,根据文件夹数量调整，少时可以去掉
				System.err.println("统计中。。。");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void add() {
		synchronized (App.class) { //上锁，保证fileSum原子操作 TODO 给Class对象上锁又意味着什么,为什么不是Object obj=new Object(); obj上锁.
			fileSum ++;
			System.err.println("当前文件数量: " + fileSum);
		}
	}
	
	public class ThreadFile extends Thread {
		
		private String tmpDir = "";
		private List<ThreadFile> threads = new Vector<>();   //当前目录下多线程数
		private boolean runed = false;
		
		public ThreadFile(String tmpDir) {
			this.tmpDir = tmpDir;
		}
		
		@Override
		public void run() {
			File file = new File(tmpDir);
			if(null == file || !file.exists()) {
				//如果不存在退出
				runed = true;
				return;
			}
			try {
				Thread.sleep(100);//TODO 为什么要sleep一下
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(file.isFile()) {
				System.out.println("文件: " + file.getPath());
				//如果是文件，执行+1
				add();
				runed = true;
				return;
			} else {
				System.out.println("目录: " + tmpDir);
				//如果是文件夹，读取子目录或者文件
				File[] files = file.listFiles();
				for(File tmp : files) {
					//循环丢出多线程执行统计
					ThreadFile thread = new ThreadFile(tmp.getPath());
					threads.add(thread);
					thread.start();
					System.err.println("threads size:"+threads.size());
				}
				runed = true;
			}
		}
		
		/**
		 * 是否运行完成<br>
		 * 不用{@link Thread#isAlive()} 是为了防止threads添加跟获取发生不一致性引发异常
		 * @return
		 */
		public boolean isComplete() {
			System.err.println("统计路径: " + tmpDir);
			boolean flag = true;
			if(!runed) {
				return !flag;
			}
			for(ThreadFile tf : threads) {
				if(!tf.isComplete()) {
					//有一个没完成就代表没运行完成
					flag = false;
					break;
				}
			}
			
			return flag;
		}
	}

}
