package com.shengfq.net;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 网页爬取DOM转换工具
 * @author shengfq
 * @version 1.0
 * @date 2022/3/31 11:29
 */
public class JsoupUtil {
    public static int REQUEST_COUNT=3;
    /**
     * 功能：检测当前URL是否可连接或是否有效,
     * 描述：最多连接网络 3 次, 如果 3 次都不成功，视为该地址不可用
     * @param  urlStr 指定URL网络地址
     * @return URL
     */
    public synchronized boolean isConnect(String urlStr) {
        int counts = 0;
        boolean retu =false;
        if (urlStr == null || urlStr.length() <= 0) {
            return retu;
        }
        while (counts < REQUEST_COUNT) {
            long start = 0;
            try {
                start = System.currentTimeMillis();
                Connection.Response response= Jsoup.connect(urlStr).execute();
                int state = response.statusCode();
               // System.out.println("请求断开的URL一次需要："+(System.currentTimeMillis()-start)+"毫秒");
                if (state == 200) {
                    retu = true;
                }
                break;
            }catch (Exception ex) {
                counts++;
                continue;
            }
        }
        return retu;
    }
    /**
     * 1.爬取url对应的HTML保存到数据库
     * 2.对document做修改
     * 3.存储到本地路径
     * 4.返回一个GeneratePathDto对象
     * 5.删除本地文件
     * */
    public String spiderFromUrl(String sourceUrl)  {

        String sourceContent="";
        try {
            Document doc = Jsoup.connect(sourceUrl).get();
            Elements metaCT = doc.getElementsByAttributeValue("http-equiv", "Content-Type");
            metaCT.stream().forEach(item -> {
                Element element = item.attr("content", "text/html; charset=utf-8");
            });
            Elements metaCS=doc.getElementsByAttributeValue("charset","gb2312");
            metaCS.stream().forEach(item -> {
                Element element = item.attr("charset", "utf-8");
            });
           // sourceContent = changeCharset(doc.html(), "utf-8");
            sourceContent=doc.html();
        }catch(IOException e){
            e.printStackTrace();
        }
        return sourceContent;
    }

    /**
     * 字符串编码转换的实现方法
     * @param str  待转换编码的字符串
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }
}
