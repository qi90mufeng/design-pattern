package com.mybatis.v2;

import com.mybatis.v1.BusinessLogMapperXml;
import com.mybatis.v2.annotation.Insert;
import com.mybatis.v2.annotation.Select;

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
       //namespace   V2版本优先处理annotation
        if (method.getAnnotations() != null){
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println("进入mapperProxy，注解：" + annotation.annotationType());
                if(annotation.annotationType().equals(Select.class)){
                    String sql = ((Select)annotation).value();
                    return myV2SqlSession.selectOne(sql, args[0]);
                }else if(annotation.annotationType().equals(Insert.class)){
                    String sql = ((Insert)annotation).value();
                    return myV2SqlSession.insert(sql);
                }
            }
        }
        //xml有问题  xml解析比较麻烦，用投机的方式代替xml没意思， 忽略掉
        if (method.getDeclaringClass().getName().equals(BusinessLogMapperXml.namespace)){
            String sql = BusinessLogMapperXml.sqlMapping.get(method.getName());
            return myV2SqlSession.selectOne(sql, args[0]);
        }

        return method.invoke(this, args);
    }
}
