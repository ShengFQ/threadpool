package com.shengfq.regEx.chapter1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则表达式的基本案例
 * 从给定的字母数字字符串中查找数字字符串
 * */
public class RegexMatches {
    public static void main(String[] args) {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
