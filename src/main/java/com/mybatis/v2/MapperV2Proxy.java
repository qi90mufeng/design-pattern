package com.mybatis.v2;

import com.mybatis.v1.BusinessLogMapperXml;
import com.mybatis.v1.MyConfiguration;
import com.mybatis.v1.MySqlSession;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperV2Proxy implements InvocationHandler{

    private MyV2SqlSession myV2SqlSession;

    public MapperV2Proxy(MyV2SqlSession myV2SqlSession) {
        this.myV2SqlSession = myV2SqlSession;
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
        if (method.getAnnotations() != null){
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println(annotation.annotationType());
                if(annotation.annotationType().equals(Select.class)){
                    String sql = ((Select)annotation).value();
                    return myV2SqlSession.selectOne(sql, args[0]);
                }
            }
        }
        if (method.getDeclaringClass().getName().equals(BusinessLogMapperXml.namespace)){
            String sql = BusinessLogMapperXml.sqlMapping.get(method.getName());
            return myV2SqlSession.selectOne(sql, args[0]);
        }

        return method.invoke(this, args);
    }
}
