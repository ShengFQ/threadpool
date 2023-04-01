package com.shengfq.serilize.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * copyRight 二三三网络技术
 * className     com.shengfq.serilize.fastjson.FastjsonDemo
 * description   TODO
 *
 * @author shengfq
 * @version 1.0
 * @date 2022/3/21 17:55
 */
public class FastjsonDemo {
    static String message="{\"body\":{\"id\":897},\"header\":{\"isRapid\":false,\"sid\":\"cioohn1hz4dmrdttlpv3\",\"system\":\"ess-union-app-builder\",\"taskId\":\"bms.app.add\",\"timestamp\":1647845791605}}";
    public static void main(String[] args) {
        parse();
    }

    private static void parse(){
        // 解析头部参数
        System.out.println("before "+message);
        message= StringEscapeUtils.unescapeHtml4(message);
        System.out.println("after "+message);
        DtsRequest request = JSONObject.parseObject(message, DtsRequest.class);
        System.out.println("request:"+request.toString());
    }
}
