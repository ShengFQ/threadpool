package com.shengfq.io.bytes;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/**
 * 格式化的内存输入
 * 1.in.readByte()读取字节，无法判断字节是否有效合法，因此无法判断结尾，报java.io.EOFException
 * 2.采用available()方法预估还有多少字节可存取*/
public class FormattedMemoryInput {
    
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(BufferedInputFile.read("/Users/sheng/Documents/workspace7/threadpool/src/main/java/com/shengfq/model/Person.java").getBytes()));
//        byte c;
//        while((c = in.readByte()) !=-1) {
//            System.out.print((char) c);
//        }
        while(in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}