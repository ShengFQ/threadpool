package com.shengfq.net;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @author shengfq
 * @version 1.0
 * @date 2022/4/15 19:55
 */
public class UrlUtils {
    public static final String FILE_HOST="https://file.233.com";
    public static final String PATH_PREFIX="/cms/law/";
    public static final String SUFFIX=".json";
    private static final String URL_STR="https://file.233.com/cms/law/law-jax.json";

    public static void main(String[] args) {
        String path=createOssFilePath();
        printPath(path);
    }
    /**
     *file:/cms/law/fbc30796b0364bb0.json
     * path:/cms/law/fbc30796b0364bb0.json
     * */
    public static void printPath(String path){
        try {
            URL url = new URL(path);
            System.out.println("file:"+url.getFile());
            System.out.println("path:"+url.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    /**
     * path:https://file.233.com/cms/law/352d4d62647046c0.json
     * */
    public static String createOssFilePath(){
        String fileName = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        String url=new StringBuffer(FILE_HOST).append(PATH_PREFIX).append(fileName).append(SUFFIX).toString();
        return url;
    }
    /**
     * 从url中获取完整路径
     * */
    public static String getFilePath(String url){
        URL url1=null;
        String path=null;
        try {
            url1=new URL(url);
            path=url1.getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getFileName(String url){
        URL url1=null;
        String file=null;
        try {
            url1=new URL(url);
            file=url1.getFile();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return file;
    }

}
