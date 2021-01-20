package com.shengfq.io.bytes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 缓存输入文件，防止频繁与文件交互
 * 1.采用装饰器模式，BufferedReader从FileReader中读取字符,FileReader为字符数据源
 * 2.FileReader继承InputStreamReader，实例化一个FileInputStream对象作为字节数据源，
 * 3.InputStreamReader继承Reader，包含StreamDecoder，将字节数据转换为字符；编码格式没有指定时采用默认编码。
 * 4.Reader可以实现对FileInputStream加锁*/
public class BufferedInputFile {

    public static String read(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = bufferedReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferedReader.close();
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/sheng/Documents/workspace7/threadpool/src/main/java/com/shengfq/model/Person.java"));
    }
}