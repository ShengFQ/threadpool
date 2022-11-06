package com.shengfq.functional;


import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter<T> {
    public static <T> List<T> filter(List<T> list, BooleanFunctionalInterface b){
        if (CollectionUtil.isEmpty(list)){
            return new ArrayList<>(0);
        }

        List<T> result = new ArrayList<>(list.size());
        for(int i=0; i<list.size(); i++){
            T t = list.get(i);
            if (b.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
