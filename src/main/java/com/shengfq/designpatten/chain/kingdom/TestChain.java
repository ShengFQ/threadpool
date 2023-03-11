package com.shengfq.designpatten.chain.kingdom;

/**
 * ClassName: TestChain
 * Description: 责任链模式
 * 核心对象:
 * RequestHandler
 * OrcKing
 * Request
 *
 * 责任链的本质:
 * 1.建立抽象RequestHandler,包含了next处理对象的引用.
 * 2.每个节点处理对象都继承抽象,但是都只能处理自己的任务类型,不是自己的任务类型,就将任务传递给下一个.
 * 3.建立链路,通过构造函数,建立任务流程节点实例
 * 4.根据实际的任务类型,传递任务到不同的节点.不是自己的任务就传递给下一个处理对象.
 * 责任链的业务场景:
 * 管道pipeline处理模式,filter,interceptor.JSR303验证器.
 * @author shengfq
 * @date: 2023/1/5 2:11 下午
 */
public class TestChain {
    public static void main(String[] args) {
        //实例化-建立handler链条 ,链条的每个环节顺序是可变的,处理者能处理的任务也是固定的,每个人只能干自己擅长的活,当出现了
        ChainFactoryBuilder builder=new ChainFactoryBuilder();

        builder.makeRequest(new Request(RequestType.KING,"我是国王"));
        //当请求是DEFEND_CASTLE任务,只有command能处理
        builder.makeRequest(new Request(RequestType.DEFEND_CASTLE, "保卫城堡"));
        //当请求是TORTURE_PRISONER,只有officer能处理
        builder.makeRequest(new Request(RequestType.TORTURE_PRISONER, "守卫监狱"));
        //当请求是COLLECT_TAX,只有soldier能处理
        builder.makeRequest(new Request(RequestType.COLLECT_TAX, "收集税收"));
    }
}
