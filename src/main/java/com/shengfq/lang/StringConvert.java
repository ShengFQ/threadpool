package com.shengfq.lang;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 字符串转换
 * @author sheng
 * @date 2020-08-12
 * */
public class StringConvert {
    static final String content="abcd_ccd#_*12322w";
    static final String url="https://www.233.com/test/zq/xueba/202203/2114063872349.html";
    public static void main(String[] args) {
       // String value=StringFilter(content);
      //  System.out.println(value);
        netUtil(url);
    }

    public static void getImei(){
        String temp="88:4A:18:01:30:33";
        String target=temp.substring(temp.length()-5,temp.length());
        System.out.println(target);
    }

    public static void getMac(){
        String temp="884A18013033";
        StringBuffer bleMac=new StringBuffer();
        int n=0;
        while(n<12){
            if(temp.trim().length()<12){
                break;
            }
            bleMac.append(temp.substring(n,n+2)).append(":");
            n+=2;
        }
        if(bleMac.length()>17) {
            bleMac.delete(bleMac.lastIndexOf(":"), bleMac.length());
        }
        System.out.println(bleMac);
    }
    /**
     * 打印ASCII码字符串
     * */
    public  static void printAscII(){
        char asc=0x68;
        System.out.println(asc);
    }

    public static String StringFilter(String str) throws PatternSyntaxException {
        // 清除掉所有特殊字符
        String regEx="[`~_!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
    /**
     * https://www.233.com/kaoyan/tag/282024/index.html //size=7 host:index=3 domain:index=4 tag:index=5 tagId:index=6 index.html:index=7
     * https://www.233.com/kaoyan/tiaoji/202203/28155312139822.html //size=7 domain:index=4 filePath:index=5+6 fileName:index=7
     * */
    public static  void explainUrl(String sourceUrl){
        sourceUrl= URLUtil.normalize(sourceUrl);
        if(sourceUrl.contains("test")){
            sourceUrl=sourceUrl.replace("/test","");
        }
        String path=URLUtil.getPath(sourceUrl);
        List<String> content=StrUtil.split(sourceUrl,"/");
        String host="",domain="",fileName="",filePath="";
        try {
            host=content.get(2);
            domain=content.get(3);
            fileName=content.get(content.size()-1);
            int bIndex=StrUtil.indexOf(sourceUrl,'/',20);
            int eIndex=sourceUrl.indexOf(fileName);
            filePath= sourceUrl.substring(bIndex,eIndex);
        }catch(Exception e){

        }
        System.out.println("host:"+host);
        System.out.println("domain:"+domain);
        System.out.println("fileName:"+fileName);
        System.out.println("filePath:"+filePath);
    }

    public static void netUtil(String source){
       boolean ping= NetUtil.ping(source,3000);
        System.out.println("ping url:"+source+" is "+ping);
    }
}
