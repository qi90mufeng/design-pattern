package com.mybatis.v2;

import com.mybatis.v1.MyExecutor;
import org.apache.ibatis.executor.Executor;
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

    public MyExecutor newExecutor(MyExecutor executor){
        executor = (MyExecutor) interceptor.plugin(executor);
        return executor;
    }

}
