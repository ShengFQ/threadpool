package com.shengfq.lambda.functional;

@FunctionalInterface
public interface Predicate<T> {
    /**
     * 挑选苹果的条件行为
     * */
    boolean test(T apple);
}
