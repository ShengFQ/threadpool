package com.shengfq.algorithm.recursion;
/**
 * 斐波那契数列
 * 递归算法
 * */
public class Fibonacci {
    /**
     * 递归实现
     * 空间复杂度:O(n)
     * */
   private static int f(int n){
        // 1.先写递归结束条件
        if(n <= 1){
            return n;
        }
        // 2.接着写等价关系式
        int v= f(n-1) + f(n - 2);
       return v;
    }
    /**
     * 动态规划实现
     * 时间复杂度:O(n)
     * */
    public static int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            /* Add the previous 2 numbers in the series and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
       int s= fib(6); //result = 8
        System.out.println(s);
    }
}
