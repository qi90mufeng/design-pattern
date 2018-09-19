package com.spring.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PrimaryFinanceStrategy implements RouteStrategy {

    private String strategyName = "资金优先策略";

    @Override
    public String getRouter(String name) {

        return null;
    }

    @Override
    public String getName() {
        return strategyName;
    }
}
