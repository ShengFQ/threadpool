package com.shengfq.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName: TestApp
 * Description: 泛型
 * 泛型集合/泛型类/泛型方法/
 * @author shengfq
 * @date: 2022/12/28 4:50 下午
 */
public class TestApp {

    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator();
        A w = xi.next();
        while (xi.hasNext()) {
            A x = xi.next();
            if (w.compareTo(x) < 0)
                w = x;
        }
        return w;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hollis");
        map.put("wechat", "Hollis");
        map.put("blog", "www.hollischuang.com");

    }
}
