package com.design.pattern.strategy.transportation;

/**
 * 策略-公交车方式
 *
 */
public class BusPort  implements PortMent{

    public String port() {
        return "选择了公交车出行";
    }
}
