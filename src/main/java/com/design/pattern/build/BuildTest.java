package com.design.pattern.build;

public class BuildTest {

    public static void main(String[] args) {
        HouseBuilder houseBuilder = new ConcreteHouseBuilderA();
        HouseDirector.createHouse(houseBuilder);
    }
}
