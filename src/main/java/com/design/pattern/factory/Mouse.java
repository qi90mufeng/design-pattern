package com.design.pattern.factory;

/**
 * @author fujin
 * @version $Id: Mouse.java, v 0.1 2018-04-02 16:07 Exp $$
 */
public class Mouse implements Device {
    @Override
    public String getName() {
        return "当前生产的是鼠标";
    }
}
