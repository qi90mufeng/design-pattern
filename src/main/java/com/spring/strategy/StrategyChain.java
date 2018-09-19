package com.spring.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Slf4j
public class StrategyChain {
    @Autowired
    private List<RouteStrategy> strategies;

    @PostConstruct
    public void init() {
        log.info("启动时策略链优先级:" + strategies.toString());
    }

    public String doChain(String name) {
        for (RouteStrategy s : strategies){
            System.out.println(s.getName());
        }

        return null;
    }
}
