package com.shengfq.regEx.chapter1;



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基础表达式
 * @author shengfq
 * @date 2020-12-02
 * */
public class BasicReg {
    static String patternStr = "(.*)(\\d+)(.*)";
    static Pattern pattern= Pattern.compile(patternStr);
    /**
     *
     * */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext(pattern)){
            String txt=input.next();
            Matcher matcher= pattern.matcher(txt);
        }
    }
}
