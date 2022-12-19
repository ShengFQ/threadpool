package com.shengfq.designpatten.decorator.file;
/**
 * 文件读写抽象
 * */
public interface DataSource {
    void writeData(String data);

    String readData();
}
