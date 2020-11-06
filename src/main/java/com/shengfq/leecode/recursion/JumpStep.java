package com.shengfq.leecode.recursion;
/**
 * 递归调用
 * 青蛙跳台阶
 * **/
public class JumpStep {
    //1、第一递归函数功能
    private static int f(int n){
        //2、找出递归结束的条件
        if(n<=2){
            return n;
        }
        //3.找出函数的等价关系式
        return f(n-1)+f(n-2);
    }
}
