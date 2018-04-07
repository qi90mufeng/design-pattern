package com.mybatis.mapper;

import com.mybatis.entity.BusinessLog;
import com.mybatis.v2.Select;
/**
 * @author fujin
 * @version $Id: BusinessLogMapper.java, v 0.1 2018-04-03 13:27 Exp $$
 */
public interface BusinessLogMapper {

    BusinessLog selectByPrimaryId(Integer id);

    @Select("select id, user_id, method_code, method_name from a_business_log where id = %d")
    BusinessLog selectById(Integer id);
}