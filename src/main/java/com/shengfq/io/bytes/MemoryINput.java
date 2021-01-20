package com.shengfq.io.bytes;

import java.io.IOException;
import java.io.StringReader;
/**
 * 将文件读入内存
 * 具体形式：new StringReader(new BufferdReader(new FileReader(filename)))
 * 通过缓存读文件，防止每读一个字节，都与文件直接交互*/
public class MemoryINput {

    static String filename = "/Users/sheng/Documents/workspace7/threadpool/src/main/java/com/shengfq/model/Person.java";
    
    public static void main(String[] args) throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read(filename));
        int c;
        while((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}