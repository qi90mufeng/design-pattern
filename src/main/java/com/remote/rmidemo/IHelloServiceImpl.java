package com.remote.rmidemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IHelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    protected IHelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException{
        return "hello";
    }
}
