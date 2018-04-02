package com.design.pattern.factory.abstractf;

import com.design.pattern.factory.Device;

/**
 * @author fujin
 * @version $Id: AbstractDeviceFactory.java, v 0.1 2018-04-02 16:19 Exp $$
 */
public abstract class AbstractDeviceFactory {

    abstract Device getMouse();

    abstract Device getKeyBoard();
}
