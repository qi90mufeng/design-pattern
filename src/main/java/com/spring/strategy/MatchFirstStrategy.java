package com.spring;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MatchFirstStrategy implements RouteStrategy {

    private String strategyName = "最先适配策略";

    @Override
    public String getRouter(String name) {

        return null;
    }

    @Override
    public String getName() {
        return strategyName;
    }
}
