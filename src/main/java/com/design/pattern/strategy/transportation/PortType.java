package com.design.pattern.strategy.transportation;

/**
 * 出行方式枚举类
 */
public enum PortType {
    BIKE_PORT(new BikePort()),
    BUS_PORT(new BusPort()),
    METRO_PORT(new MetroPort()),
    TAXI_PORT(new TaxiPort()),
    WALK_PORT(new WalkPort());

    private PortMent portMent;

    PortType(PortMent portMent){
        this.portMent = portMent;
    }

    public PortMent get(){
        return this.portMent;
    }
}
