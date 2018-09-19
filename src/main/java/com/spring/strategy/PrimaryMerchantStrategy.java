package com.spring.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class PrimaryMerchantStrategy implements RouteStrategy {
    private String strategyName = "商户优先策略";

    @Override
    public String getRouter(String name) {
        return null;
    }

    @Override
    public String getName() {
        return strategyName;
    }
}
