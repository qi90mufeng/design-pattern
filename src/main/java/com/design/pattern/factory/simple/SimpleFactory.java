package com.design.pattern.factory.simple;

import com.design.pattern.factory.Device;
import com.design.pattern.factory.KeyBoard;
import com.design.pattern.factory.Mouse;

/**
 * @author fujin
 * @version $Id: SimpleFactory.java, v 0.1 2018-04-02 16:09 Exp $$
 */
public class SimpleFactory {

    public Device getDevice(String name){
        switch(name){
            case "mouse":
                return new Mouse();
            case "keyboard":
                return new KeyBoard();
            default:
                throw new RuntimeException("暂不支持该设备");
        }

    }
}
