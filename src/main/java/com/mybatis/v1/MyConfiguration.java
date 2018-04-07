package com.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyConfiguration {

    private static Map<String, String> mapperings = new HashMap<>();

    public <T> T getMapper(Class<T> clazz, MySqlSession mySqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(mySqlSession));
    }

}
