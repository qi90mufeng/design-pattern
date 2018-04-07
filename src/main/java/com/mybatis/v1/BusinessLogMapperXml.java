package com.mybatis.v1;

import java.util.HashMap;
import java.util.Map;

public class BusinessLogMapperXml {

    public static final String namespace = "com.mybatis.mapper.BusinessLogMapper";

    public static final Map<String, String> sqlMapping = new HashMap<>();

    static{
        sqlMapping.put("selectByPrimaryId","select * from a_business_log where id=%d");
    }
}
