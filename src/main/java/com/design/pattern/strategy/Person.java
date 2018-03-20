package com.design.pattern.strategy;

import com.design.pattern.strategy.transportation.PortType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 人类抽象类
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 职业
     */
    private String profession;

    /**
     * 上班，选择出行方式
     */
    public abstract void howToWorkFromHome(PortType type);

}