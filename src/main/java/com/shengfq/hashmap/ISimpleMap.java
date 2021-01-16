package com.shengfq.hashmap;

/**
 * 简单的Map接口ADT定义
 *
 * @author sheng
 * @date 2020-07-28
 * @copyright shengfq
 */
public interface ISimpleMap {
    /**
     * 添加元素
     * */
    void put(Object key, Object value);
    /**
     * 获取元素
     * */
    Object get(Object key);
    /**
     * 获取个数
     * */
    int size();
    /**
     * 是否为空
     * */
    boolean isEmpty();
    /**
     * 移除元素
     * **/
    Object remove(Object key);

    /**
     * 定义内部接口
     */
    interface Entry {
        Object getKey();

        Object getValue();
    }
}