package com.design.pattern.singleton.hungry;

/**
 * @author fujin
 * @version $Id: SingleOne.java, v 0.1 2018-04-03 9:21 Exp $$
 */
public class SingleOne {

    private static SingleOne instance = new SingleOne();

    public static SingleOne getInstance(){
        return instance;
    }
}
