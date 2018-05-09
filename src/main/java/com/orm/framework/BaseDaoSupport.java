package com.orm.framework;

import javax.sql.DataSource;

/**
 * 抽象类可以写一些默认的功能
 * 但是不能被实例化
 * 通过子类继承父类，
 */
public abstract class BaseDaoSupport {

    protected abstract void setDataSource(DataSource dataSource);
}
