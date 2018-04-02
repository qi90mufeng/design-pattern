package com.design.pattern.factory.factory;

import com.design.pattern.factory.Device;
import com.design.pattern.factory.Mouse;

/**
 * @author fujin
 * @version $Id: MouseFctory.java, v 0.1 2018-04-02 16:15 Exp $$
 */
public class MouseFctory {
    Device getMouse(){
        return new Mouse();
    }
}
