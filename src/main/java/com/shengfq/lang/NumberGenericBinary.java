package com.shengfq.lang;
/**
 * 进制转换
 * @author sheng
 * */
public class NumberGenericBinary {

        /**
         * 十进制>>>>>二进制
         * */
        public static void toBin(int n)
        {
            trans(n,1,1);
        }


        /**
         * 十进制>>>>>十六进制
         * */
        public static void toHex(int n)
        {
            trans(n,15,4);
        }


        /**
         * 十进制>>>>>八进制
         * */
        public static void toOtc(int n)
        {
            trans(n,7,3);
        }


        /***转换过程*/
        public static void trans(int x,int base,int offset)
        {
            if(x==0)
            {
                System.out.print(0);
                return;
            }
            char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            //定义一个临时的存储容器，（一个整型数据占四个八位)
            char[] arr = new char[32];
            //定义一个指针移动
            int pos = arr.length;
            while(x!=0)
            {
                int temp = x & base;
                arr[--pos] = chs[temp];
                x = x >>> offset;
            }
            for(int i = pos; i <arr.length; i++)
            {
                System.out.print(arr[i]);
            }
            System.out.println();
        }

    //主函数测试
    public static void main(String[] args)
    {
        int num;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("please enter a integer number:");
        num = sc.nextInt();
        toBin(num);
        toHex(num);
        toOtc(num);
    }
}
