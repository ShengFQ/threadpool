package com.shengfq.designpatten.strategy.abs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean
    public HandlerFactory<String, StrategyInterfaceA> strategyInterfaceAFactory(){
        return new HandlerFactory<>(StrategyInterfaceA.class);
    }
    @Bean
    public HandlerFactory<Integer, StrategyInterfaceB> strategyInterfaceBFactory(){
        return new HandlerFactory<>(StrategyInterfaceB.class);
    }
    @Bean
    public HandlerFactory<Long, StrategyInterfaceC> strategyInterfaceCFactory(){
        return new HandlerFactory<>(StrategyInterfaceC.class);
    }

}
