package com.design.pattern.build;

public class ConcreteHouseBuilderA implements HouseBuilder {

    private House house;

    public ConcreteHouseBuilderA() {
        this.house = new House();
    }

    @Override
    public void buildRoom(int roomNum) {
        house.roomNum = roomNum;
    }

    @Override
    public void buildDoor(int room1, int room2) {
        house.doorNum = room1 + room2;
    }

    @Override
    public House getHouse() {
        return house;
    }
}
