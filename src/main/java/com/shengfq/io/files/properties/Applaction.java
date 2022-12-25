package com.shengfq.io.files.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/thc1987/article/details/78789426
 * @date 2017年6月1日 下午3:49:30
 * @version V1.0
 * @since JDK ： 1.7
 */
@SpringBootApplication
@RestController
public class Applaction {
    /**
     *
     * 第四种方式：通过注册监听器(`Listeners`) + `PropertiesLoaderUtils`的方式
     *
     * @author zyd
     * @throws UnsupportedEncodingException
     * @since JDK 1.7
     */
    @RequestMapping("/listener")
    public Map<String, Object> listener() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll(PropertiesListenerConfig.getAllProperty());
        return map;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(Applaction.class);
        // 第四种方式：注册监听器
        application.addListeners(new PropertiesListener("app-config.properties"));
        application.run(args);
    }
}
