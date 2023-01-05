package com.shengfq.designpatten.chain;

/**
 * ClassName: TestChain
 * Description: 责任链模式
 * 责任链的本质:
 * 责任链的业务场景:
 * @author shengfq
 * @date: 2023/1/5 2:11 下午
 */
public class TestChain {
    public static void main(String[] args) {
        //实例化-建立handler链条 ,链条的顺序是固定的,处理者能处理的任务也是固定的,每个人只能干自己擅长的活,当出现了
        OrcKing king = new OrcKing();
        //当请求是DEFEND_CASTLE任务,只有command能处理
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "保卫城堡"));
        //当请求是TORTURE_PRISONER,只有officer能处理
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "守卫监狱"));
        //当请求是COLLECT_TAX,只有soldier能处理
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "收集税收"));
    }
}
