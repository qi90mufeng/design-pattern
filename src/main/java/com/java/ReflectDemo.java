package com.java;

import java.lang.reflect.Type;

public class ReflectDemo {

    public static void main(String[] args) {
        //Type是所有类型的父接口, 如原始类型(raw types,对应Class)、
        // 参数化类型(parameterized types, 对应ParameterizedType)、
        // 数组类型(array types,对应GenericArrayType)、
        // 类型变量(type variables, 对应TypeVariable)
        // 和基本(原生)类型(primitive types, 对应Class),
        // 子接口有ParameterizedType, TypeVariable<D>, GenericArrayType, WildcardType, 实现类有Class
    }
}
