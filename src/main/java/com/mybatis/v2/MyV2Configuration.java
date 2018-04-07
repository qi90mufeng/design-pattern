package com.mybatis.v2;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyV2Configuration {

    private static Map<String, String> mapperings = new HashMap<>();

    public <T> T getMapper(Class<T> clazz, MyV2SqlSession myV2SqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperV2Proxy(myV2SqlSession));
    }

}
