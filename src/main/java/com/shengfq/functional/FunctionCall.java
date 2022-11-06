package com.shengfq.functional;

import java.util.Map;
import java.util.function.*;

/**
 * 函数式接口的调用
 * 1.定义(甲方)
 * 2.调用(甲方)
 * 3.实现(乙方)
 * */

public class FunctionCall {
    /**
     * 消费型接口调用
     * */
    public void testConsumer(Consumer<Integer> consumer,Integer num){
        consumer.accept(num);
    }
    /**
     * 供给型接口
     * */
    public Integer testSupplier(Supplier<Integer> supplier){
        return  supplier.get();
    }

    public Integer testFunctional(Function<Integer,Integer> function,Integer param){
        return function.apply(param);
    }
    /**
     * @param predicate 接口引用
     * @param a 接口的参数对象
     * */
    public boolean testPredicate(Predicate<Integer> predicate,Integer a){
        return predicate.test(a);
    }

    public void testBiConsumer(BiConsumer<Integer,Integer> biConsumer, Integer a, Integer b){
        biConsumer.accept(a,b);
    }
}
