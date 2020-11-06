package com.shengfq.hashmap;

/**
 * 简单的Map接口
 *
 * @author sheng
 * @date 2020-07-28
 * @copyright shengfq
 */
public interface ISimpleMap {

    void put(Object key, Object value);

    Object get(Object key);

    int size();

    boolean isEmpty();

    /**
     * 定义内部接口
     */
    interface Entry {
        Object getKey();

        Object getValue();
    }
}