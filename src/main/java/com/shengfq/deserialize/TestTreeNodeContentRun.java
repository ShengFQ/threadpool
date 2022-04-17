package com.shengfq.deserialize;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试JSON大文档序列化反序列化
 * @author shengfq
 * @version 1.0
 * @date 2022/4/11 08:48
 */

public class TestTreeNodeContentRun {
    private static final String FILE_PATH="file.json";
    private List<TreeNodeContent> resultVo;

    public TestTreeNodeContentRun(){
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        TestTreeNodeContentRun testRun=new TestTreeNodeContentRun();
        //序列化对象到文件
        TreeNodeContent newNode= testRun.addNode();
        //将文件反序列化到对象
        List<TreeNodeContent> resultVo =  testRun.jsonDeserialize();
        //添加对象
        testRun.addNode(resultVo,newNode);

        //修改对象
        //testRun.updateNode(resultVo,newNode);
        //重新序列化到文件
        testRun.jsonSerialize(resultVo);
    }
    /**
     * 添加节点内容
     * 1.在列表的末尾添加一个新节点,也可以在中间位置
     * */
    private void addNode(List<TreeNodeContent> list,TreeNodeContent update){
        int j= update.getJ();
        if(j>=list.size()){
            //直接在末尾加
            list.add(update);
        }else{
            list.set(j,update);
        }
        //list.add(update);//直接在末尾加
    }
    /**
     * 修改节点内容
     * 1.找到源节点
     * 2.修改节点内容
     * */
    private void updateNode(List<TreeNodeContent> list,TreeNodeContent update){
        list= list.stream().filter(item->item.getId().equals(update.getId())).map(item->{
            return assembleVo(item,update);
        }).collect(Collectors.toList());
    }

    /**
     *待添加的节点
     * */
    private TreeNodeContent addNode(){
        TreeNodeContent addNode=new TreeNodeContent();
        addNode.setId(74);
        addNode.setLawWebContent("新加的内容");
        addNode.setJ(18);
        addNode.setShowChild(1);
        addNode.setPosition(76);
        addNode.setType(3);
        addNode.setContent("新加的标题");
        addNode.setParentId(31);
        return addNode;
    }

    private static TreeNodeContent assembleVo(TreeNodeContent source,TreeNodeContent target){
        source.setId(target.getId());
        source.setLawWebContent(target.getLawWebContent());
        source.setJ(target.getJ());
        source.setShowChild(target.getShowChild());
        source.setPosition(target.getPosition());
        source.setType(target.getType());
        source.setContent(target.getContent());
        source.setParentId(target.getParentId());
        return source;
    }

    /**
     * 超大JSON数组序列化
     * */
    private void jsonSerialize(List<TreeNodeContent> resultVo){
        JSONWriter writer=null;
        try {
            writer = new JSONWriter(new FileWriter(FILE_PATH));
            writer.startArray();
            for(int i=0;i<resultVo.size();i++){
                writer.writeValue(resultVo.get(i));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.endArray();
                try {
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 超大JSON数组反序列化
     * */
    private List<TreeNodeContent> jsonDeserialize(){
        List<TreeNodeContent> resultVo=new ArrayList<>();
        Type type = new TypeReference<TreeNodeContent>(){}.getType();
        String filePath = FILE_PATH;
        JSONReader reader=null;
        try {
             reader = new JSONReader(new FileReader(filePath));
            reader.startArray();
            while (reader.hasNext()){
                TreeNodeContent vo=reader.readObject(type);
                resultVo.add(vo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                reader.endArray();
                reader.close();
            }
        }
        return resultVo;
    }
}
