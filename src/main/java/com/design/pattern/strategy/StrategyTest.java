package com.design.pattern.strategy;

import com.design.pattern.strategy.transportation.PortType;

public class StrategyTest {

    // 测试类  动态选择最合适的方式
    public static void main(String[] args) {
        /*
        *  特征提取  距离、开销、押金、锻炼身体
        *
        * 1、步行方式
        *   一般用于近距离（0-3km）、无开销（主要是消耗体能）、无押金、散步及锻炼身体
        *
        * 1、自行车方式
        *   一般用于近距离交通（0-5km）、花费少（单车月票只要几毛钱，不开月票也是一小时1块）、有押金、锻炼身体
        *
        * 2、公交车方式
        *   距离可长可短、花费少（一般2元一次，无需押金，可以开月票、无需耗体能）、无押金、不是锻炼身体的方式
        *
        * 3、地铁方式
        *   距离可长可短、花费少、无押金、不是锻炼身体的方式
        *
        *  4、出租车方式
        *   距离可长可短（一般3km以上，适合市内交通，适用于赶时间，或需要舒适的人群）、花费大（无需押金，可以开发票）、无押金、不是锻炼身体的方式
        *
        * 设置不同人群的需要，自动选择不同的出行方式
        *
        * 暂时完成的功能： 设置人群，选择出行方式
        * 未来：可以根据人群的需要，选择优势出行方式
        */
        Person p1 = new Person("Lily", 18, "咕炮学院老师") {
            @Override
            public void howToWorkFromHome(PortType type) {
                System.out.println(getName() + type.get().port());
            }
        };

        p1.howToWorkFromHome(PortType.TAXI_PORT);


        Person p2 = new Person("Tom", 18, "咕炮学院老师") {
            @Override
            public void howToWorkFromHome(PortType type) {
                System.out.println(getName() + type.get().port());
            }
        };

        p2.howToWorkFromHome(PortType.WALK_PORT);
    }
}
