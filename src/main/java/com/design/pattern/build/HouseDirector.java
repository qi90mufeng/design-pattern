package com.design.pattern.build;

public class HouseDirector {

    public static House createHouse(HouseBuilder concreteBuilder){
        concreteBuilder.buildRoom(1);
        concreteBuilder.buildRoom(2);

        concreteBuilder.buildDoor(1, 2);
        concreteBuilder.buildDoor(2, 1);

        return concreteBuilder.getHouse();
    }
}
