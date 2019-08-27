package demo.shengfq.jvm;

import java.util.Vector;

public class HeapAlloc {
	public static void main(String[] args) {
		printDumpOOM();
	}
	
	public static void printMemory(){
		printRuntime();
		
		byte[] b=new byte[1*1024*1024];
		System.out.println("分配了1M空间给数组");
		printRuntime();
		
		b = new byte[4*1024*1024];	
		System.out.println("分配了4M空间给数组");
		printRuntime();
	}
	public static void printRuntime(){
		System.out.println("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory()+"bytes");
		System.out.println("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()+"bytes");
		System.out.println("total mem=");
		System.out.println(Runtime.getRuntime().totalMemory()+"bytes");
	}
	
	public static void printDumpOOM(){
		Vector v = new Vector();
		for (int i = 0; i < 25; i++) {
			v.add(new byte[1*1024*1024]);
		}

	}
}
