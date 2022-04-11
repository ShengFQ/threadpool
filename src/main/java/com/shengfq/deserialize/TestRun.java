package com.shengfq.deserialize;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.lang.reflect.Type;

/**
 * 测试泛型类的文档序列化和反序列化
 * 结论:
 * 序列化一个对象时，要求它的属性要么是基本数据类型，如果是引用数据类型，这个引用数据类型也必须实现Serializable接口。
 *序列化一个数组，要求元素类型实现Serializable接口。
 * @author shengfq
 * @version 1.0
 * @date 2022/4/11 08:48
 */

public class TestRun {
    private static final String FILE_PATH="file.out";
    private static String JSON_CONTENT="";
    private ResultVo<PageVo<DataVo>> resultVo;

    public TestRun(){
        DataVo dataVo=new DataVo();
        PageVo pageVo=new PageVo();
        ResultVo resultVo=new ResultVo();
        resultVo.setData(pageVo);
        pageVo.setT(dataVo);
        dataVo.setName("hello");
        dataVo.setTotal(1);
        this.resultVo=resultVo;
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        TestRun testRun=new TestRun();
        testRun.jsonSerialize();
        testRun.jsonDeserialize();
    }

    private  void serialize() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(FILE_PATH);
        ObjectOutputStream oos=new ObjectOutputStream(fileOutputStream);
        oos.writeObject(resultVo);
        oos.close();
    }

    private void deserialize() throws IOException,ClassNotFoundException{
        FileInputStream fileInputStream=new FileInputStream(FILE_PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        resultVo=(ResultVo<PageVo<DataVo>>)objectInputStream.readObject();
        System.out.println(resultVo.getData().getT().getName());
    }

    private void jsonSerialize(){
       JSON_CONTENT= JSONObject.toJSONString(resultVo);
    }
    /**
     * fastjson反序列化泛型类,安全起见应该要先指定反序列化的的类型.
     * */
    private void jsonDeserialize(){
        Type type = new TypeReference<ResultVo<PageVo<DataVo>>>(){}.getType();
        ResultVo<PageVo<DataVo>> resultVo = JSONObject.parseObject(JSON_CONTENT, type);
        System.out.println(resultVo.getData().getT().getName());
    }
}
