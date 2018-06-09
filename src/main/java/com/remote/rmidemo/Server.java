package com.remote.rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static final String SERVER_REGISTER_NAME = "helloService";

    public static void main(String[] args) {
        try {
            int port = 1099;
            IHelloService helloService = new IHelloServiceImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://127.0.0.1/Hello", helloService);

            System.out.println("服务启动成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
