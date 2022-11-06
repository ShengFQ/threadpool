package com.shengfq.lang;
/**
 * 字符串转换
 * @author sheng
 * @date 2020-08-12
 * */
public class StringConvert {
    public static void main(String[] args) {
        printAscII();
    }

    public static void getImei(){
        String temp="88:4A:18:01:30:33";
        String target=temp.substring(temp.length()-5,temp.length());
        System.out.println(target);
    }

    public static void getMac(){
        String temp="884A18013033";
        StringBuffer bleMac=new StringBuffer();
        int n=0;
        while(n<12){
            if(temp.trim().length()<12){
                break;
            }
            bleMac.append(temp.substring(n,n+2)).append(":");
            n+=2;
        }
        if(bleMac.length()>17) {
            bleMac.delete(bleMac.lastIndexOf(":"), bleMac.length());
        }
        System.out.println(bleMac);
    }
    /**
     * 打印ASCII码字符串
     * */
    public  static void printAscII(){
        char asc=0x68;
        System.out.println(asc);
    }
}
