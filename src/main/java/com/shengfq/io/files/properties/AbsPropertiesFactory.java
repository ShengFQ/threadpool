package com.shengfq.io.files.properties;

import org.springframework.beans.BeansException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ClassName: AbsPropertiesFactory
 * Description: 抽象工厂实现类,模板父类
 *
 * @author shengfq
 * @date: 2022/12/20 5:57 下午
 */
public class AbsPropertiesFactory implements PropertiesListener{
    public  Map<String, String> propertiesMap = new HashMap<>();

    public AbsPropertiesFactory(String propertyFileName){
        loadAllProperties(propertyFileName);
    }
    /**
     * 根据文件路径读取文件
     *
     * @param propertyFileName
     */
    @Override
    public void loadAllProperties(String propertyFileName) {
        try {
            Resource resource=new FileSystemResource(propertyFileName);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            processProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理属性文件
     *
     * @param props
     */
    @Override
    public void processProperties(Properties props) throws BeansException {
        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            try {
                // PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
                propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes("ISO-8859-1"), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 根据key获取value
     *
     * @param name
     */
    @Override
    public String getProperty(String name) {
        return propertiesMap.get(name);
    }

    /**
     * 获取所有的属性值
     */
    @Override
    public Map<String, String> getAllProperty() {
        return propertiesMap;
    }
    /**
     * 获取熟悉内容对象
     * */
    @Override
    public AbsContent getContent() {
        if(propertiesMap==null){
            return null;
        }
        //如果增加了文档模板类型,这里需要变更
        Xzdjtzs entity=new Xzdjtzs();
        entity.setYhmc(getProperty("F[0].P1[0].SZJG[0]"));
        entity.setXyrxm(getProperty("F[0].P1[0].HMHQLR[0]"));
        entity.setYhzh(getProperty("F[0].P1[0].CH[0]"));
        entity.setTzywlx(getProperty("F[0].P1[0].WSLX[1]"));
        entity.setDjlx(getProperty("F[0].P1[0].QT[0]"));
        entity.setDjse(getProperty("F[0].P1[0].DJSE[0]"));
        entity.setDjksrq(getProperty("F[0].P1[0].date-KSSJ-dd[0]"));
        entity.setDjjsrq(getProperty("F[0].P1[0].date-JSSJ-dd[0]"));
        return entity;
    }
}
