package com.remote.rpc;

public class IGpHelloImpl implements  IGpHello {
    @Override
    public String sayHello(String name) {
       return "Hello," + name;
    }
}
