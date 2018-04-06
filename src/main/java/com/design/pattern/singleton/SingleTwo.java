package com.design.pattern.singleton;

import java.io.Serializable;

/**
 * 内部类实现单例
 *
 *
 *
 *
 * @author fujin
 * @version $Id: SingleTwo.java, v 0.1 2018-04-03 9:28 Exp $$
 */
public class SingleTwo implements Serializable{

    private static boolean isInstance = false;

    public static SingleTwo getInstance() {
        return InnerInstance.INSTANCE;
    }

    public static final class InnerInstance{
       private static final SingleTwo INSTANCE = new SingleTwo();
    }
}
