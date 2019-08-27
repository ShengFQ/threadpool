package demo.shengfq.wujun;
/**
* 常见数组操作
*/
public class ArrayOpt{
	//查找最小数
	private static int[] array1={42,10,20,22,50,4};

	public void findLeast(int[] array){
		//原理就是默认第一个是最小值,遍历数组,比最小值还小的就交换位置
		int least=array[0];
		for(int i=0;i<array.length;i++){
			if(array[i]<least){
				int temp=least;
					least=array[i];
					array[i]=temp;
			}
		}
		System.out.print("least:"+least);
	}

	

	public static void main(String[] args){
		ArrayOpt opt=new ArrayOpt();
		opt.findLeast(array1);
	}
}