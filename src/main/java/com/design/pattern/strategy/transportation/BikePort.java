package com.design.pattern.strategy.transportation;

/**
 * 策略-自行车方式
 *
 */
public class BikePort implements PortMent{

    public String port() {
        return "选择了自行车出行";
    }
}
