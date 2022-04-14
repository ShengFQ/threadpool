package com.shengfq.deserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

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
    private static final String FILE_PATH="file.json";
    private ResultVo<PageVo<DataVo>> resultVo;

    public TestRun(){
        ResultVo resultVo1=new ResultVo();
        PageVo pageVo=new PageVo();
        DataVo dataVo=new DataVo();
        dataVo.setName("hello");
        dataVo.setTotal(1);
        pageVo.setData(dataVo);
        pageVo.setPageNum(1);
        pageVo.setPageSize(10);
        resultVo1.setData(pageVo);
        resultVo1.setCode(1);
        resultVo1.setMsg("失败");

        this.resultVo=resultVo1;
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        TestRun testRun=new TestRun();
        //序列化对象到文件
        testRun.jsonSerialize(testRun.resultVo);
        //将文件反序列化到对象
        ResultVo<PageVo<DataVo>> resultVo =  testRun.jsonDeserialize();
        //修改对象
        PageVo pageVo=new PageVo();
        DataVo dataVo=new DataVo();
        dataVo.setName("shengfq");
        dataVo.setTotal(2);
        pageVo.setData(dataVo);
        pageVo.setPageNum(2);
        pageVo.setPageSize(2);
        resultVo.setData(pageVo);
        resultVo.setCode(1);
        resultVo.setMsg("失败");
        //
        testRun.jsonSerialize(resultVo);
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
        //System.out.println(resultVo.getData().getT().getName());
    }

    private void jsonSerialize(ResultVo resultVo){
       String jsonString= JSONObject.toJSONString(resultVo);
        //判断文件是否存在
        File file = new File(FILE_PATH);
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件创建成功");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jsonString.getBytes());
            fileOutputStream.close();
            System.out.println("json数据保存到成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * fastjson反序列化泛型类,安全起见应该要先指定反序列化的的类型.
     * */
    private ResultVo<PageVo<DataVo>> jsonDeserialize(){
        ResultVo<PageVo<DataVo>> resultVo=null;
        Type type = new TypeReference<ResultVo<PageVo<DataVo>>>(){}.getType();
        String filePath = FILE_PATH;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            resultVo = JSONObject.parseObject(in,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resultVo.getData().getData().toString());
        return resultVo;
    }
}
