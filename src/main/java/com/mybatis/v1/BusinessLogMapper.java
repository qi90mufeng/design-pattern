package com.mybatis.v1;

/**
 * @author fujin
 * @version $Id: interface.java, v 0.1 2018-04-03 13:27 Exp $$
 */
public interface BusinessLogMapper {

    BusinessLog selectByPrimaryId(Integer id);
}