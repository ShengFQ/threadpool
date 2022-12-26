package com.shengfq.io.files.properties;

import org.springframework.beans.BeansException;

import java.util.Map;
import java.util.Properties;

/**
 * 属性文件读取工厂
 * @author shengfq
 * @date 2022-12-20
 * */
public interface PropertiesListener {

    /**
     * 处理属性文件
     * */
    void processProperties(Properties props) throws BeansException;
    /**
     * 根据文件路径读取文件
     * */
    void loadAllProperties(String propertyFileName);
    /**
     * 根据key获取value
     * */
    String getProperty(String name);
    /**
     * 获取所有的属性值
     * */
    Map<String, String> getAllProperty();

    AbsContent getContent();
}
