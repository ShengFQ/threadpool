package com.shengfq.designpatten.chain.demo1;

/**
 * ClassName: ChainTest
 * Description: 测试责任链
 *
 * @author shengfq
 * @date: 2024/2/3 11:39 上午
 */
public class ChainTest {
    public static void main(String[] args) {
        Request request=new Request("zhangsan",3);
        AbsHandler head=new AbsHandler.Builder().addHandler(new Handler1()).addHandler(new Handler2()).build();
        head.buildChain(request);
    }
}
