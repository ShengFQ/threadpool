package com.shengfq.designpatten.chain.kingdom;

/**
 * ClassName: ChainFactoryBuilder
 * Description:
 *
 * @author shengfq
 * @date: 2023/3/11 11:08 上午
 */
public class ChainFactoryBuilder {
    IHandler chain;

    public ChainFactoryBuilder(){
        buildChain();
    }
    private void buildChain() {
        IHandler king = new OrcKing();
        IHandler orcCommander = new OrcCommander();
        IHandler orcOfficer = new OrcOfficer();
        IHandler orcSoldier = new OrcSoldier();
        king.setNext(orcCommander);
        orcCommander.setNext(orcOfficer);
        orcOfficer.setNext(orcSoldier);
        chain=king;
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }

}
