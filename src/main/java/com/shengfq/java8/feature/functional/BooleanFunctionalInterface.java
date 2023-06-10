package com.shengfq.java8.feature.functional;
/**
 * 自定义函数式接口
 * */
@FunctionalInterface
public interface BooleanFunctionalInterface<T> {
    boolean test(T t);
}
