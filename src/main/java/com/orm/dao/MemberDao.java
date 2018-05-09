package com.orm.dao;

import com.orm.framework.BaseDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository
public class MemberDao extends BaseDaoSupport {
    @Override
    @Resource(name = "dataSource")
    protected void setDataSource(DataSource dataSource) {

    }
}
