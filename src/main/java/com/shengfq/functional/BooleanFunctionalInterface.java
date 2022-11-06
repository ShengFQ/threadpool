package com.shengfq.functional;
/**
 * 自定义函数式接口
 * */
@FunctionalInterface
public interface BooleanFunctionalInterface<T> {
    boolean test(T t);
}
