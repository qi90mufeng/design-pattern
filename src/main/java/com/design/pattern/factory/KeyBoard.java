package com.design.pattern.factory;

/**
 * @author fujin
 * @version $Id: KeyBoard.java, v 0.1 2018-04-02 16:08 Exp $$
 */
public class KeyBoard implements Device {
    @Override
    public String getName() {
        return "当前生产的是键盘";
    }
}
