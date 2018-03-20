package com.design.pattern.strategy.transportation;

/**
 * 策略-出租车方式
 *
 */
public class TaxiPort  implements PortMent{

    public String port() {
        return "选择了出租车出行";
    }
}
