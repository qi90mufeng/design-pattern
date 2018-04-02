package com.design.pattern.factory.factory;

import com.design.pattern.factory.Device;
import com.design.pattern.factory.KeyBoard;

/**
 * @author fujin
 * @version $Id: KeyBoardFactory.java, v 0.1 2018-04-02 16:16 Exp $$
 */
public class KeyBoardFactory {

    Device getKeyBoard(){
        return new KeyBoard();
    }
}
