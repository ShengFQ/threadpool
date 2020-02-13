package demo.shengfq.leecode.recursion;
/**
 * 斐波那契数列
 * 递归算法
 * */
public class Fibonacci {

   private static int f(int n){
        // 1.先写递归结束条件
        if(n <= 2){
            return 1;
        }
        // 2.接着写等价关系式
        return f(n-1) + f(n - 2);
    }

    public static void main(String[] args) {
       int s= f(6);
        System.out.println(s);
    }
}
