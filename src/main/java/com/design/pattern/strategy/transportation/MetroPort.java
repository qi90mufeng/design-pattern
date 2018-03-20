package com.design.pattern.strategy.transportation;

/**
 * 策略-乘坐地铁方式
 *
 */
public class MetroPort  implements PortMent{

    public String port() {
        return "选择了地铁出行";
    }
}