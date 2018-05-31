
package com.mybatis.v2.plugin;

import com.mybatis.v1.MyExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;


/**
 * @author fujin
 * @version $Id: SelectPlugin.java, v 0.1 2018-04-10 11:55 Exp $$
 */
@Intercepts({@Signature(
        type= MyExecutor.class,
        method = "query",
        args = {String.class,Object.class})})
public class SelectPlugin implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("-----------------select plugin ------------------");
        Object[] args = invocation.getArgs();
        System.out.println("-----------------now is going to fetch log where id = " + args[0] + "------------------");
        return invocation.proceed();
    }
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }
}
