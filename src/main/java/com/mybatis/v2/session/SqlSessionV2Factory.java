
package com.mybatis.v2.session;

import com.mybatis.v2.MyV2Configuration;

/**
 *
 * @author fujin
 * @version $Id: SqlSessionV2Factory.java, v 0.1 2018-04-11 10:42 Exp $$
 */
public interface SqlSessionV2Factory {

    //TODO 暂未使用工厂生成sqlsession
    MyV2SqlSession openSqlSession(MyV2Configuration myV2Configuration);
}
