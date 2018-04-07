package com.mybatis.v1;

import com.mybatis.v2.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler{

    private MySqlSession mySqlSession;

    public MapperProxy(MySqlSession mySqlSession) {
        this.mySqlSession = mySqlSession;
    }

    /**
     * 找到sql
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //namespace
        if (method.getDeclaringClass().getName().equals(BusinessLogMapperXml.namespace)){
            String sql = BusinessLogMapperXml.sqlMapping.get(method.getName());
            return mySqlSession.selectOne(sql, args[0]);
        }

        return method.invoke(this, args);
    }
}
