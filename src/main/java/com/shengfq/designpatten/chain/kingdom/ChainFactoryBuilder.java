package com.shengfq.designpatten.chain.kingdom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * ClassName: ChainFactoryBuilder
 * Description:
 *
 * @author shengfq
 * @date: 2023/3/11 11:08 上午
 */
@Service
public class ChainFactoryBuilder {
    IHandler chain;

    @Autowired
    public ChainFactoryBuilder(){
        buildChain();
    }

    @PostConstruct
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
