package com.spring.strategy;

/**
 * 资金选择策略
 * Created by fengzibin.
 * Date: 2018-03-09
 * Time: 下午4:47
 */
public interface RouteStrategy {

    String getName();

    String getRouter(String name);
}
