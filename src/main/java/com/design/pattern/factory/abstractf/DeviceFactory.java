package com.design.pattern.factory.abstractf;

import com.design.pattern.factory.Device;
import com.design.pattern.factory.KeyBoard;
import com.design.pattern.factory.Mouse;

/**
 * @author fujin
 * @version $Id: DeviceFactory.java, v 0.1 2018-04-02 16:22 Exp $$
 */
public class DeviceFactory extends  AbstractDeviceFactory{
    @Override
    Device getMouse() {
        return new Mouse();
    }

    @Override
    Device getKeyBoard() {
        return new KeyBoard();
    }
}
