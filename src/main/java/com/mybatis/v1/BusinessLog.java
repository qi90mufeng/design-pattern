package com.mybatis.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fujin
 * @version $Id: BusinessLog.java, v 0.1 2018-04-03 13:47 Exp $$
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessLog {
    /**
     * '主键ID，自增序列'
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 接口代码:6位
     */
    private String  methodCode;

    /**
     * 接口名称
     */
    private String methodName;

    //.....
}
