package com.mybatis.mapper;

import com.mybatis.entity.BusinessLog;
import com.mybatis.v2.annotation.Insert;
import com.mybatis.v2.annotation.Select;
/**
 * @author fujin
 * @version $Id: BusinessLogMapper.java, v 0.1 2018-04-03 13:27 Exp $$
 */
public interface BusinessLogMapper {

    BusinessLog selectByPrimaryId(Integer id);

    @Select("select id, user_id, method_code, method_name from a_business_log where id = %d")
    BusinessLog selectById(Integer id);

    @Insert("INSERT INTO `sina`.`a_business_log` (`id`, `user_id`, `method_code`, `method_name`, `in_param`, `out_param`, `status`, `create_time`, `update_time`, `create_ymd`, `remark`) VALUES (null, '80', '050202', '部署流程', '{\\\"deployName\\\":\\\"微农贷\\\"}', 'orderApply:1:7504', '100', '2017-10-31 18:19:44', NULL, '20171031', NULL)")
    int insertRecord();
}