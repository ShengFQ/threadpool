package demo.shengfq.wujun;
import java.lang.Math;
/**
*编程题:0-51分别代表52张扑克牌, 0-12为红桃区间 ,13-25为方块区间,26-38为黑桃区间 39-51为梅花 给定一个0-51的随机数字,给出花色和数字
* A,2,3,4,5,6,7,8,9,10,J,Q,K
*/
public class GuessPoker{
	//思路 输入一个数字,返回 花色和数值. 花色,数值要存放到两个数组里面.
	//怎么得到花色
	//花色已经存放到了数组,只需要能返回一个正确的数组索引值就能得到花色
	//这个数字%13=花色索引
	//怎么得到数值
	//数值也已经存放到了数组,只需要返回一个正确的数组索引就能得到数值
	//这个数字/13=具体数值

	//流程 初始化这副牌 洗牌 发牌(每人13张)
	public static void main(String[] args){
		print();
	}

	public static void print(){
		//begin
		int[] poker=new int[52];
	String[] hua= {"红桃","方块","黑桃","梅花"};
	String[] zhi= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	for(int i=0;i<poker.length;i++){
		poker[i]=i;
	}
	//suffring
	for(int i=0;i<poker.length;i++){
		//产生随机索引
		int index=(int)Math.random()*(poker.length);
		//交换		
		int temp=poker[i];
		poker[i]=poker[index];
		poker[index]=temp;		
	}
	for(int i=0;i<52;i++){
		String myhua=hua[(int)poker[i]/13];
		String myzhi=zhi[(int)poker[i]%13];
		if(i%13==0){
			System.out.println("");
		}
		System.out.print(myhua+myzhi+" ");
	}
	}

}