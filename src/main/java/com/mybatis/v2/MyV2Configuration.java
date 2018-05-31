package com.mybatis.v2;

import com.mybatis.v2.session.MyV2SqlSession;
import org.apache.ibatis.plugin.Interceptor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyV2Configuration {

    private Interceptor interceptor;

    private static Map<String, String> mapperings = new HashMap<>();

    public <T> T getMapper(Class<T> clazz, MyV2SqlSession myV2SqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperV2Proxy(myV2SqlSession));
    }

    public MyV2Configuration(Interceptor interceptor){
        this.interceptor = interceptor;
    }

    public MyV2Executor newExecutor(MyV2Executor executor){
        executor = (MyV2Executor) interceptor.plugin(executor);
        return executor;
    }

}
